package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GdLanguage
import gdscript.colors.GdColors
import gdscript.grammar.GdLexer
import gdscript.grammar.GdLexer.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class GdSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return if (tokenType !is TokenIElementType) EMPTY else when (tokenType.antlrTokenType) {
            NUMBER, HEX -> pack(GdColors.NUMBER)
            STRING -> pack(GdColors.STRING)
            IDENTIFIER -> pack(GdColors.PARAMETER)
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
            RETURN -> pack(GdColors.KEYWORD)
            LINE_COMMENT -> pack(GdColors.LINE_COMMENT)
            BLOCK_COMMENT -> pack(GdColors.BLOCK_COMMENT)
            else -> EMPTY
        }
    }

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(GdLanguage, GdLexer(null))

}