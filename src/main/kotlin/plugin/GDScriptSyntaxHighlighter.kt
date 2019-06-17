package plugin

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import plugin.parser.GDScriptLexer
import plugin.parser.GDScriptLexer.*

typealias DefaultColor = DefaultLanguageHighlighterColors

class GDScriptSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        val lexer = GDScriptLexer(null)
        return ANTLRLexerAdaptor(GDScript, lexer)
    }

    override fun getTokenHighlights(type: IElementType) = arrayOf(mapToHighlight(type))

    private fun mapToHighlight(tokenType: IElementType): TextAttributesKey? {
        if (tokenType !is TokenIElementType)
            return null
        return when (tokenType.antlrTokenType) {
            VARIABLE, IF -> DefaultColor.KEYWORD
            IDENTIFIER -> DefaultColor.IDENTIFIER
            NUMBER -> DefaultColor.NUMBER
            STRING -> DefaultColor.STRING
            LINE_COMMENT -> DefaultColor.LINE_COMMENT
            else -> null
        }
    }

}
