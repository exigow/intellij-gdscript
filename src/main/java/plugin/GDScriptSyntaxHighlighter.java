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

    private static final TextAttributesKey[] NUMBER = toArray(DefaultLanguageHighlighterColors.NUMBER);
    private static final TextAttributesKey[] STRING = toArray(DefaultLanguageHighlighterColors.STRING);
    private static final TextAttributesKey[] IDENTIFIER = toArray(DefaultLanguageHighlighterColors.IDENTIFIER);
    private static final TextAttributesKey[] KEYWORD = toArray(DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey[] LINE_COMMENT = toArray(DefaultLanguageHighlighterColors.LINE_COMMENT);

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
                return STRING;
            case GDScriptLexer.IDENTIFIER:
                return IDENTIFIER;
            case GDScriptLexer.LINE_COMMENT:
                return LINE_COMMENT;
            case GDScriptLexer.IF_KEYWORD:
            case GDScriptLexer.WHILE_KEYWORD:
            case GDScriptLexer.EXTENDS_KEYWORD:
            case GDScriptLexer.VAR_KEYWORD:
                return KEYWORD;
        }
        return EMPTY;
    }

    private static TextAttributesKey[] toArray(TextAttributesKey key) {
        return new TextAttributesKey[] {key};
    }

}
