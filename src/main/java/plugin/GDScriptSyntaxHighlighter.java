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

    public static final TextAttributesKey NUMBER = createTextAttributesKey("GDSCRIPT_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STRING = createTextAttributesKey("GDSCRIPT_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("GDSCRIPT_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);

    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};

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
        if (antlrType == GDScriptLexer.NUMBER) {
            return NUMBER_KEYS;
        } else if (antlrType == GDScriptLexer.STRING) {
            return STRING_KEYS;
        } else if (antlrType == GDScriptLexer.IDENTIFIER) {
            return IDENTIFIER_KEYS;
        }
        return EMPTY_KEYS;
    }
}