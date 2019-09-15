package gdscript.adaptors

import com.intellij.lang.Language
import org.antlr.v4.runtime.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

open class SyntaxHighlighterFactoryAdaptor(
    private val language: Language,
    private val lexer: Lexer,
    val highlighting: Map<TextAttributesKey, List<Int>>
) : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = object : SyntaxHighlighterBase() {

        override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
            if (tokenType !is TokenIElementType)
                pack(null)
            else
                pack(mapToColor(tokenType.antlrTokenType))

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(language, lexer)

        private fun mapToColor(tokenType: Int) =
            highlighting.entries
                .find { (_, tokens) -> tokens.contains(tokenType) }
                ?.key

    }

}

