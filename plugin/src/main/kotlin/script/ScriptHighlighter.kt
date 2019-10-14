package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import script.ScriptColor.*
import script.adaptors.LexerAdaptor
import script.psi.TokenSet

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element))

    override fun getHighlightingLexer() = LexerAdaptor()

    private fun matchingToColor(element: IElementType?) = when (element) {
        in TokenSet.LINE_COMMENT -> LINE_COMMENT.key
        in TokenSet.STRING -> STRING.key
        in TokenSet.NUMBER -> NUMBER.key
        in TokenSet.KEYWORD -> KEYWORD.key
        in TokenSet.NODE -> NODE.key
        in TokenSet.IDENTIFIER -> IDENTIFIER.key
        in TokenSet.OPERATION_SIGN -> OPERATION_SIGN.key
        in TokenSet.COMMA -> COMMA.key
        in TokenSet.DOT -> DOT.key
        in TokenSet.BRACES -> BRACES.key
        in TokenSet.PARENTHESES -> PARENTHESES.key
        in TokenSet.BRACKETS -> BRACKETS.key
        else -> null
    }

}
