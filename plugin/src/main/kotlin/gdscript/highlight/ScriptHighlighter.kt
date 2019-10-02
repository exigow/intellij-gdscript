package gdscript.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.grammar.ScriptLexer
import gdscript.grammar.ScriptLexer.*
import gdscript.languages.ScriptLanguage
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
        NUMBER -> DefaultLanguageHighlighterColors.NUMBER
        STRING -> DefaultLanguageHighlighterColors.STRING
        KEYWORD -> DefaultLanguageHighlighterColors.KEYWORD
        NODE -> DefaultLanguageHighlighterColors.METADATA
        IDENTIFIER -> DefaultLanguageHighlighterColors.IDENTIFIER
        OPERATOR_SIGN -> DefaultLanguageHighlighterColors.OPERATION_SIGN
        COMMA -> DefaultLanguageHighlighterColors.COMMA
        DOT -> DefaultLanguageHighlighterColors.DOT
        BRACES -> DefaultLanguageHighlighterColors.BRACES
        PARENTHESES -> DefaultLanguageHighlighterColors.PARENTHESES
        BRACKETS -> DefaultLanguageHighlighterColors.BRACKETS
        LINE_COMMENT -> DefaultLanguageHighlighterColors.LINE_COMMENT
        BLOCK_COMMENT -> DefaultLanguageHighlighterColors.BLOCK_COMMENT
        else -> null
    }

}
