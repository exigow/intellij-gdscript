package gdscript.files

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GDScriptResourceLexer
import gdscript.lang.ResourceLanguage
import gdscript.lang.token.ResourceTokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ResourceHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = SyntaxHighlighter

    companion object SyntaxHighlighter : SyntaxHighlighterBase() {

        override fun getTokenHighlights(element: IElementType): Array<TextAttributesKey> =
            pack(matchingToColor(element))

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(ResourceLanguage, GDScriptResourceLexer(null))

        private fun matchingToColor(element: IElementType) = when (element) {
            in ResourceTokenSet.KEYWORDS -> DefaultLanguageHighlighterColors.KEYWORD
            in ResourceTokenSet.IDENTIFIERS -> DefaultLanguageHighlighterColors.INSTANCE_FIELD
            in ResourceTokenSet.NUMBERS -> DefaultLanguageHighlighterColors.NUMBER
            in ResourceTokenSet.STRINGS -> DefaultLanguageHighlighterColors.STRING
            in ResourceTokenSet.LINE_COMMENTS -> DefaultLanguageHighlighterColors.LINE_COMMENT
            else -> null
        }

    }

}
