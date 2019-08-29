package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GDScriptLanguage
import gdscript.colors.Color
import gdscript.grammar.GDScriptLexer
import gdscript.grammar.GDScriptLexer.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class SyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        if (tokenType !is TokenIElementType)
            pack(null)
        else
            pack(mapToColor(tokenType.antlrTokenType)?.textAttributesKey)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(GDScriptLanguage, GDScriptLexer(null))

    private fun mapToColor(tokenType: Int): Color? =
        when (tokenType) {
            NUMBER, HEX -> Color.NUMBER
            STRING -> Color.STRING
            IDENTIFIER -> Color.PARAMETER
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
            RETURN -> Color.KEYWORD
            LINE_COMMENT -> Color.LINE_COMMENT
            BLOCK_COMMENT -> Color.BLOCK_COMMENT
            else -> null
        }

}
























