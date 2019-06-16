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
import plugin.parser.GDScriptLexer
import plugin.parser.GDScriptParser

class GDScriptSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        val lexer = GDScriptLexer(null)
        return ANTLRLexerAdaptor(GDScript, lexer)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey?> {
        if (tokenType !is TokenIElementType)
            return arrayOf(null)
        return arrayOf(mapTokenToTextAttribute(tokenType))
    }

    private fun mapTokenToTextAttribute(tokenType: TokenIElementType): TextAttributesKey? {
        val keywords = arrayOf(GDScriptLexer.VAR, GDScriptLexer.WHILE, GDScriptLexer.IF, GDScriptLexer.ELSE, GDScriptLexer.RETURN, GDScriptLexer.PRINT, GDScriptLexer.FUNC, GDScriptLexer.TYPEINT, GDScriptLexer.TYPEFLOAT, GDScriptLexer.TYPESTRING, GDScriptLexer.TYPEBOOLEAN, GDScriptLexer.TRUE, GDScriptLexer.FALSE)
        return when (tokenType.antlrTokenType) {
            in keywords -> KEYWORD
            GDScriptLexer.ID -> ID
            GDScriptLexer.STRING -> STRING
            GDScriptLexer.COMMENT -> LINE_COMMENT
            GDScriptLexer.LINE_COMMENT -> BLOCK_COMMENT
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
            PSIElementTypeFactory.defineLanguageIElementTypes(GDScript, GDScriptParser.tokenNames, GDScriptParser.ruleNames)
        }

    }
}
