package gdscript.files

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GDScriptLexer
import gdscript.lang.ScriptLanguage
import gdscript.lang.ScriptTokenSet
import gdscript.options.ColorTextAttributeKey.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ScriptHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = SyntaxHighlighter

    companion object SyntaxHighlighter : SyntaxHighlighterBase() {

        override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
            pack(matchingToColor(element)?.key)

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(ScriptLanguage, GDScriptLexer(null))

        private fun matchingToColor(element: IElementType?) = when (element) {
            in ScriptTokenSet.LINE_COMMENTS -> LINE_COMMENT
            in ScriptTokenSet.STRINGS -> STRING
            in ScriptTokenSet.NUMBERS -> NUMBER
            in ScriptTokenSet.KEYWORDS -> KEYWORD
            in ScriptTokenSet.NODES -> NODE
            in ScriptTokenSet.IDENTIFIERS -> IDENTIFIER
            in ScriptTokenSet.OPERATION_SIGNS -> OPERATION_SIGN
            in ScriptTokenSet.COMMAS -> COMMA
            in ScriptTokenSet.DOTS -> DOT
            in ScriptTokenSet.BRACES -> BRACES
            in ScriptTokenSet.PARENTHESES -> PARENTHESES
            in ScriptTokenSet.BRACKETS -> BRACKETS
            else -> null
        }

    }

}
