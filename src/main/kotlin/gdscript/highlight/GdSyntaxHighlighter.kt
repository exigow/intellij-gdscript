package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GdLanguage
import gdscript.colors.GdColor
import gdscript.grammar.GdLexer
import gdscript.grammar.GdLexer.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class GdSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        if (tokenType !is TokenIElementType)
            pack(null)
        else
            pack(mapToColor(tokenType.antlrTokenType)?.textAttributesKey)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(GdLanguage, GdLexer(null))

    private fun mapToColor(tokenType: Int): GdColor? =
        when (tokenType) {
            NUMBER, HEX -> GdColor.NUMBER
            STRING -> GdColor.STRING
            IDENTIFIER -> GdColor.PARAMETER
            EXPORT, ONREADY, VAR, SETGET,
            CONST,
            STATIC, FUNC,
            FOR, IN,
            WHILE,
            CLASS,
            EXTENDS,
            CLASS_NAME,
            ENUM,
            IF,
            ELIF,
            ELSE,
            RETURN -> GdColor.KEYWORD
            LINE_COMMENT -> GdColor.LINE_COMMENT
            BLOCK_COMMENT -> GdColor.BLOCK_COMMENT
            else -> null
        }

}
























