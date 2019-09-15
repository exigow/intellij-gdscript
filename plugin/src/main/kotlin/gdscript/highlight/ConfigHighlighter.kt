package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.ConfigLanguage
import gdscript.colors.ScriptColor
import gdscript.grammar.ConfigLexer
import gdscript.grammar.ConfigLexer.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ConfigHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        if (tokenType !is TokenIElementType)
            pack(null)
        else
            pack(mapToColor(tokenType.antlrTokenType)?.textAttributesKey)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ConfigLanguage, ConfigLexer(null))

    private fun mapToColor(tokenType: Int): ScriptColor? =
        when (tokenType) {
            KEYWORD -> ScriptColor.KEYWORD
            NUMBER -> ScriptColor.NUMBER
            STRING -> ScriptColor.STRING
            COMMENT -> ScriptColor.LINE_COMMENT
            else -> null
        }

}
























