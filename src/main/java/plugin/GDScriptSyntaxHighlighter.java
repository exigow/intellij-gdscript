package plugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;
import plugin.parser.GDScriptLexer;

public class GDScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey[] NUMBER = toArray(DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey[] STRING = toArray(DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey[] PARAMETER = toArray(DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey[] KEYWORD = toArray(DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey[] LINE_COMMENT = toArray(DefaultLanguageHighlighterColors.LINE_COMMENT);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        GDScriptLexer lexer = new GDScriptLexer(null);
        return new ANTLRLexerAdaptor(GDScript.INSTANCE, lexer);
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (!(tokenType instanceof TokenIElementType))
            return EMPTY;
        int antlrType = ((TokenIElementType) tokenType).getANTLRTokenType();
        switch (antlrType) {
            case GDScriptLexer.NUMBER:
                return NUMBER;
            case GDScriptLexer.STRING:
            case GDScriptLexer.UNTERMINATED_STRING:
                return STRING;
            case GDScriptLexer.PARAMETER:
                return PARAMETER;
            case GDScriptLexer.LINE_COMMENT:
                return LINE_COMMENT;
            case GDScriptLexer.IF:
            case GDScriptLexer.WHILE:
            case GDScriptLexer.EXTENDS:
            case GDScriptLexer.VAR:
            case GDScriptLexer.CONST:
            case GDScriptLexer.FUNC:
            case GDScriptLexer.RETURN:
            case GDScriptLexer.PASS:
                return KEYWORD;
        }
        return EMPTY;
    }

    private static TextAttributesKey[] toArray(TextAttributesKey key) {
        return new TextAttributesKey[] {key};
    }

}
