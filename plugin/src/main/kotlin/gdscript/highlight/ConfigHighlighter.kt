package gdscript.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.grammar.ConfigLexer
import gdscript.grammar.ConfigLexer.*
import gdscript.languages.ConfigLanguage
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ConfigHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        if (tokenType !is TokenIElementType)
            pack(null)
        else
            pack(mapToColor(tokenType.antlrTokenType))

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(ConfigLanguage, ConfigLexer(null))

    private fun mapToColor(tokenType: Int) =
        highlighting.entries
            .find { (_, tokens) -> tokens.contains(tokenType) }
            ?.key

    companion object {
        val highlighting = mapOf(
            DefaultLanguageHighlighterColors.KEYWORD to listOf(KEYWORD, IDENTIFIER),
            DefaultLanguageHighlighterColors.NUMBER to listOf(NUMBER),
            DefaultLanguageHighlighterColors.STRING to listOf(STRING),
            DefaultLanguageHighlighterColors.LINE_COMMENT to listOf(LINE_COMMENT)
        )
    }
}
