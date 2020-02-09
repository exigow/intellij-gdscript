package scene

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import common.Colors as Color

class SceneHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(SceneLanguage, SceneLexer(null))

    private fun matchingToColor(element: IElementType) = when (element) {
        in SceneTokenSet.KEYWORDS -> Color.KEYWORD
        in SceneTokenSet.NUMBERS -> Color.NUMBER
        in SceneTokenSet.STRINGS -> Color.STRING
        in SceneTokenSet.RESOURCES -> Color.RESOURCE
        in SceneTokenSet.LINE_COMMENTS -> Color.LINE_COMMENT
        else -> null
    }

}
