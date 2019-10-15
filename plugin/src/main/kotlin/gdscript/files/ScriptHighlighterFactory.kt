package gdscript.files

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GDScriptLexer
import gdscript.lang.ScriptLanguage
import gdscript.lang.ScriptTokenSet
import gdscript.options.ColorTextAttributeKey
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ScriptHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = SyntaxHighlighter

    companion object SyntaxHighlighter : SyntaxHighlighterBase() {

        override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
            pack(matchingToColor(element))

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(ScriptLanguage, GDScriptLexer(null))

        private fun matchingToColor(element: IElementType?) = when (element) {
            in ScriptTokenSet.LINE_COMMENT -> ColorTextAttributeKey.LINE_COMMENT.key
            in ScriptTokenSet.STRING -> ColorTextAttributeKey.STRING.key
            in ScriptTokenSet.NUMBER -> ColorTextAttributeKey.NUMBER.key
            in ScriptTokenSet.KEYWORD -> ColorTextAttributeKey.KEYWORD.key
            in ScriptTokenSet.NODE -> ColorTextAttributeKey.NODE.key
            in ScriptTokenSet.IDENTIFIER -> ColorTextAttributeKey.IDENTIFIER.key
            in ScriptTokenSet.OPERATION_SIGN -> ColorTextAttributeKey.OPERATION_SIGN.key
            in ScriptTokenSet.COMMA -> ColorTextAttributeKey.COMMA.key
            in ScriptTokenSet.DOT -> ColorTextAttributeKey.DOT.key
            in ScriptTokenSet.BRACES -> ColorTextAttributeKey.BRACES.key
            in ScriptTokenSet.PARENTHESES -> ColorTextAttributeKey.PARENTHESES.key
            in ScriptTokenSet.BRACKETS -> ColorTextAttributeKey.BRACKETS.key
            else -> null
        }

    }

}
