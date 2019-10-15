package gdscript.files

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GDScriptResourceLexer
import gdscript.lang.ResourceLanguage
import gdscript.lang.ResourceTokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ResourceHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = SyntaxHighlighter

    companion object SyntaxHighlighter : SyntaxHighlighterBase() {

        override fun getTokenHighlights(element: IElementType): Array<TextAttributesKey> =
            pack(matchingToColor(element))

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(ResourceLanguage, GDScriptResourceLexer(null))

        private fun matchingToColor(element: IElementType) = when (element) {
            in ResourceTokenSet.KEYWORD -> DefaultLanguageHighlighterColors.KEYWORD
            in ResourceTokenSet.IDENTIFIER -> DefaultLanguageHighlighterColors.INSTANCE_FIELD
            in ResourceTokenSet.NUMBER -> DefaultLanguageHighlighterColors.NUMBER
            in ResourceTokenSet.STRING -> DefaultLanguageHighlighterColors.STRING
            in ResourceTokenSet.LINE_COMMENT -> DefaultLanguageHighlighterColors.LINE_COMMENT
            else -> null
        }

    }

}
