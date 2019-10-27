package gdscript.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import GDScriptResourceLexer
import gdscript.parser.ResourceLanguage
import gdscript.token.ResourceTokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ResourceHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType): Array<TextAttributesKey> =
        pack(matchingToColor(element))

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ResourceLanguage, GDScriptResourceLexer(null))

    private fun matchingToColor(element: IElementType) = when (element) {
        in ResourceTokenSet.KEYWORDS -> DefaultLanguageHighlighterColors.KEYWORD
        in ResourceTokenSet.IDENTIFIERS -> DefaultLanguageHighlighterColors.INSTANCE_FIELD
        in ResourceTokenSet.NUMBERS -> DefaultLanguageHighlighterColors.NUMBER
        in ResourceTokenSet.STRINGS -> DefaultLanguageHighlighterColors.STRING
        in ResourceTokenSet.LINE_COMMENTS -> DefaultLanguageHighlighterColors.LINE_COMMENT
        else -> null
    }

}
