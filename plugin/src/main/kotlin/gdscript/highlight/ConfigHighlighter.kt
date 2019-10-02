package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.colors.ConfigHighlighterColors
import gdscript.grammar.ConfigLexer
import gdscript.grammar.ConfigLexer.*
import gdscript.languages.ConfigLanguage
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ConfigHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        if (element !is TokenIElementType)
            pack(null)
        else pack(getColor(element.antlrTokenType))

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ConfigLanguage, ConfigLexer(null))

    private fun getColor(tokenType: Int) = when (tokenType) {
        KEYWORD -> ConfigHighlighterColors.KEYWORD
        IDENTIFIER -> ConfigHighlighterColors.IDENTIFIER
        NUMBER -> ConfigHighlighterColors.NUMBER
        STRING -> ConfigHighlighterColors.STRING
        LINE_COMMENT -> ConfigHighlighterColors.LINE_COMMENT
        else -> null
    }

}
