package gdscript

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.lexer.ScriptLexer

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ScriptLexer()

    private fun matchingToColor(element: IElementType?) = when (element) {
        ScriptTokenType.KEYWORD -> Colors.KEYWORD
        ScriptTokenType.CLASS_NAME -> Colors.CLASS_NAME
        ScriptTokenType.DOUBLE_QUOTED_STRING, ScriptTokenType.SINGLE_QUOTED_STRING -> Colors.STRING
        ScriptTokenType.NUMBER -> Colors.NUMBER
        ScriptTokenType.IDENTIFIER -> Colors.IDENTIFIER
        ScriptTokenType.NODE -> Colors.NODE
        ScriptTokenType.CONSTANT -> Colors.CONSTANT
        ScriptTokenType.LINE_COMMENT -> Colors.LINE_COMMENT
        ScriptTokenType.COMMA -> Colors.COMMA
        ScriptTokenType.COLON -> Colors.COLON
        ScriptTokenType.SEMICOLON -> Colors.SEMICOLON
        ScriptTokenType.DOT -> Colors.DOT
        ScriptTokenType.BRACE_LEFT, ScriptTokenType.BRACE_RIGHT -> Colors.BRACES
        ScriptTokenType.PARENTH_LEFT, ScriptTokenType.PARENTH_RIGHT -> Colors.PARENTHESES
        ScriptTokenType.BRACKET_LEFT, ScriptTokenType.BRACKET_RIGHT -> Colors.BRACKETS
        else -> null
    }

}
