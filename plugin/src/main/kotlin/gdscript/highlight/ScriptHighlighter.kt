package gdscript.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.grammar.ScriptLexer
import gdscript.grammar.ScriptLexer.*
import gdscript.languages.ScriptLanguage
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        if (tokenType !is TokenIElementType)
            pack(null)
        else
            pack(mapToColor(tokenType.antlrTokenType))

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun mapToColor(tokenType: Int) =
        highlighting.entries
            .find { (_, tokens) -> tokens.contains(tokenType) }
            ?.key

    companion object {
        val highlighting = mapOf(
            DefaultLanguageHighlighterColors.NUMBER to listOf(NUMBER, HEX),
            DefaultLanguageHighlighterColors.STRING to listOf(STRING),
            DefaultLanguageHighlighterColors.PARAMETER to listOf(IDENTIFIER),
            DefaultLanguageHighlighterColors.KEYWORD to listOf(EXPORT, ONREADY, VAR, SETGET, CONST, STATIC, FUNC, FOR, IN, WHILE, CLASS, EXTENDS, CLASS_NAME, ENUM, IF, ELIF, ELSE, RETURN),
            DefaultLanguageHighlighterColors.LINE_COMMENT to listOf(LINE_COMMENT),
            DefaultLanguageHighlighterColors.BLOCK_COMMENT to listOf(BLOCK_COMMENT)
        )
    }
}
