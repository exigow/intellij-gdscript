package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import script.adaptors.ScriptLexerAdaptor
import script.colors.ScriptColor.*

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() = ScriptLexerAdaptor()

    private fun matchingToColor(element: IElementType?) = when (element) {
        in Token.LINE_COMMENT.types -> LINE_COMMENT
        in Token.STRING.types -> STRING
        in Token.NUMBER.types -> NUMBER
        in Token.KEYWORD.types -> KEYWORD
        in Token.NODE.types -> NODE
        in Token.IDENTIFIER.types -> IDENTIFIER
        in Token.OPERATION_SIGN.types -> OPERATION_SIGN
        in Token.COMMA.types -> COMMA
        in Token.DOT.types -> DOT
        in Token.BRACES.types -> BRACES
        in Token.PARENTHESES.types -> PARENTHESES
        in Token.BRACKETS.types -> BRACKETS
        else -> null
    }

}
