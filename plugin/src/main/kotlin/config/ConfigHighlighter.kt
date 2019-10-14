package config

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import config.grammar.ConfigLexer
import config.psi.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ConfigHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType): Array<TextAttributesKey> =
        pack(matchingToColor(element))

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(ConfigLanguage, ConfigLexer(null))

    private fun matchingToColor(element: IElementType) = when (element) {
        in TokenSet.KEYWORD -> ConfigColor.KEYWORD
        in TokenSet.IDENTIFIER -> ConfigColor.IDENTIFIER
        in TokenSet.NUMBER -> ConfigColor.NUMBER
        in TokenSet.STRING -> ConfigColor.STRING
        in TokenSet.LINE_COMMENT -> ConfigColor.LINE_COMMENT
        else -> null
    }

}
