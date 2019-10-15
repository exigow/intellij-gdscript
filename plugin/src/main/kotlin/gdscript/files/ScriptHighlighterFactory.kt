package gdscript.files

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GDScriptLexer
import gdscript.lang.ScriptLanguage
import gdscript.lang.TokenSet
import gdscript.options.ColorTextAttributeKey
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ScriptHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = SyntaxHighlighter

    companion object SyntaxHighlighter : SyntaxHighlighterBase() {

        override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
            pack(matchingToColor(element))

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(ScriptLanguage, GDScriptLexer(null))

        private fun matchingToColor(element: IElementType?) = when (element) {
            in TokenSet.LINE_COMMENT -> ColorTextAttributeKey.LINE_COMMENT.key
            in TokenSet.STRING -> ColorTextAttributeKey.STRING.key
            in TokenSet.NUMBER -> ColorTextAttributeKey.NUMBER.key
            in TokenSet.KEYWORD -> ColorTextAttributeKey.KEYWORD.key
            in TokenSet.NODE -> ColorTextAttributeKey.NODE.key
            in TokenSet.IDENTIFIER -> ColorTextAttributeKey.IDENTIFIER.key
            in TokenSet.OPERATION_SIGN -> ColorTextAttributeKey.OPERATION_SIGN.key
            in TokenSet.COMMA -> ColorTextAttributeKey.COMMA.key
            in TokenSet.DOT -> ColorTextAttributeKey.DOT.key
            in TokenSet.BRACES -> ColorTextAttributeKey.BRACES.key
            in TokenSet.PARENTHESES -> ColorTextAttributeKey.PARENTHESES.key
            in TokenSet.BRACKETS -> ColorTextAttributeKey.BRACKETS.key
            else -> null
        }

    }

}
