package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import script.grammar.ScriptLexer
import script.grammar.ScriptLexer.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        if (element !is TokenIElementType)
            pack(null)
        else pack(getColor(element.antlrTokenType))

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun getColor(tokenType: Int) = when (tokenType) {
        NUMBER -> ScriptHighlighterColors.NUMBER
        STRING -> ScriptHighlighterColors.STRING
        KEYWORD -> ScriptHighlighterColors.KEYWORD
        METADATA -> ScriptHighlighterColors.METADATA
        IDENTIFIER -> ScriptHighlighterColors.IDENTIFIER
        OPERATION_SIGN -> ScriptHighlighterColors.OPERATION_SIGN
        COMMA -> ScriptHighlighterColors.COMMA
        DOT -> ScriptHighlighterColors.DOT
        BRACES -> ScriptHighlighterColors.BRACES
        PARENTHESES -> ScriptHighlighterColors.PARENTHESES
        BRACKETS -> ScriptHighlighterColors.BRACKETS
        LINE_COMMENT -> ScriptHighlighterColors.LINE_COMMENT
        BLOCK_COMMENT -> ScriptHighlighterColors.BLOCK_COMMENT
        else -> null
    }

}
