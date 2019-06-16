package plugin

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import plugin.parser.GDScriptLanguageLexer
import plugin.parser.GDScriptLanguageParser

class GDScriptSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        val lexer = GDScriptLanguageLexer(null)
        return ANTLRLexerAdaptor(GDScriptLanguage, lexer)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey?> {
        if (tokenType !is TokenIElementType)
            return arrayOf(null)
        return arrayOf(mapTokenToTextAttribute(tokenType))
    }

    private fun mapTokenToTextAttribute(tokenType: TokenIElementType): TextAttributesKey? {
        val keywords = arrayOf(GDScriptLanguageLexer.VAR, GDScriptLanguageLexer.WHILE, GDScriptLanguageLexer.IF, GDScriptLanguageLexer.ELSE, GDScriptLanguageLexer.RETURN, GDScriptLanguageLexer.PRINT, GDScriptLanguageLexer.FUNC, GDScriptLanguageLexer.TYPEINT, GDScriptLanguageLexer.TYPEFLOAT, GDScriptLanguageLexer.TYPESTRING, GDScriptLanguageLexer.TYPEBOOLEAN, GDScriptLanguageLexer.TRUE, GDScriptLanguageLexer.FALSE)
        return when (tokenType.antlrTokenType) {
            in keywords -> KEYWORD
            GDScriptLanguageLexer.ID -> ID
            GDScriptLanguageLexer.STRING -> STRING
            GDScriptLanguageLexer.COMMENT -> LINE_COMMENT
            GDScriptLanguageLexer.LINE_COMMENT -> BLOCK_COMMENT
            else -> null
        }
    }

    companion object {

        val ID = createTextAttributesKey("GDSCRIPT_ID", DefaultLanguageHighlighterColors.IDENTIFIER)
        val KEYWORD = createTextAttributesKey("GDSCRIPT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING = createTextAttributesKey("GDSCRIPT_STRING", DefaultLanguageHighlighterColors.STRING)
        val LINE_COMMENT = createTextAttributesKey("GDSCRIPT_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BLOCK_COMMENT = createTextAttributesKey("GDSCRIPT_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(GDScriptLanguage, GDScriptLanguageParser.tokenNames, GDScriptLanguageParser.ruleNames)
        }

    }
}
