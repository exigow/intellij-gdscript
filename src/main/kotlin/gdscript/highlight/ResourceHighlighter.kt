package gdscript.highlight

import ResourceLexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.options.ColorTextAttributeKey
import gdscript.parser.ResourceLanguage
import gdscript.token.ResourceTokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ResourceHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ResourceLanguage, ResourceLexer(null))

    private fun matchingToColor(element: IElementType) = when (element) {
        in ResourceTokenSet.KEYWORDS -> ColorTextAttributeKey.KEYWORD
        in ResourceTokenSet.IDENTIFIERS -> ColorTextAttributeKey.INSTANCE_FIELD
        in ResourceTokenSet.NUMBERS -> ColorTextAttributeKey.NUMBER
        in ResourceTokenSet.STRINGS -> ColorTextAttributeKey.STRING
        in ResourceTokenSet.RESOURCES -> ColorTextAttributeKey.RESOURCE
        in ResourceTokenSet.LINE_COMMENTS -> ColorTextAttributeKey.LINE_COMMENT
        else -> null
    }

}
