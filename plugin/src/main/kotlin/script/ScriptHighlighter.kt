package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import script.ScriptColor.*
import script.adaptors.LexerAdaptor

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() = LexerAdaptor()

    private fun matchingToColor(element: IElementType?) = when (element) {
        in ScriptTokenSets.LINE_COMMENT.types -> LINE_COMMENT
        in ScriptTokenSets.STRING.types -> STRING
        in ScriptTokenSets.NUMBER.types -> NUMBER
        in ScriptTokenSets.KEYWORD.types -> KEYWORD
        in ScriptTokenSets.NODE.types -> NODE
        in ScriptTokenSets.IDENTIFIER.types -> IDENTIFIER
        in ScriptTokenSets.OPERATION_SIGN.types -> OPERATION_SIGN
        in ScriptTokenSets.COMMA.types -> COMMA
        in ScriptTokenSets.DOT.types -> DOT
        in ScriptTokenSets.BRACES.types -> BRACES
        in ScriptTokenSets.PARENTHESES.types -> PARENTHESES
        in ScriptTokenSets.BRACKETS.types -> BRACKETS
        else -> null
    }

}
