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

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class GDScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[] {
            createTextAttributesKey("GDSCRIPT_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    };
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[] {
            createTextAttributesKey("GDSCRIPT_STRING", DefaultLanguageHighlighterColors.STRING)
    };
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[] {
            createTextAttributesKey("GDSCRIPT_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    };
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[] {
            createTextAttributesKey("GDSCRIPT_IDENTIFIER", DefaultLanguageHighlighterColors.LINE_COMMENT)
    };
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

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
            return EMPTY_KEYS;
        int antlrType = ((TokenIElementType) tokenType).getANTLRTokenType();
        switch (antlrType) {
            case GDScriptLexer.NUMBER:
                return NUMBER_KEYS;
            case GDScriptLexer.STRING:
                return STRING_KEYS;
            case GDScriptLexer.IDENTIFIER:
                return IDENTIFIER_KEYS;
            case GDScriptLexer.COMMENT:
                return COMMENT_KEYS;
        }
        return EMPTY_KEYS;
    }

}
