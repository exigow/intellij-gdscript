package gdscript.adaptors

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ANTLRLexerHighlighter(
    private val lexer: ANTLRLexerAdaptor,
    private val conversions: Map<TextAttributesKey, List<Int>>
) : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        if (tokenType !is TokenIElementType)
            pack(null)
        else
            pack(mapToColor(tokenType.antlrTokenType))

    override fun getHighlightingLexer() = lexer

    private fun mapToColor(tokenType: Int) =
        conversions.entries
            .find { (_, tokens) -> tokens.contains(tokenType) }
            ?.key

}