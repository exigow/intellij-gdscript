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

typealias Colors = DefaultLanguageHighlighterColors

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
            VARIABLE, CONSTANT, WHILE, IF, ELSE, RETURN, FUNCTION -> Colors.KEYWORD
            IDENTIFIER -> Colors.IDENTIFIER
            NUMBER -> Colors.NUMBER
            STRING -> Colors.STRING
            LINE_COMMENT -> Colors.LINE_COMMENT
            else -> null
        }
    }

}
