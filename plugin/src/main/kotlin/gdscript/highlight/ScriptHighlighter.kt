package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.ScriptLanguage
import gdscript.colors.ScriptColor
import gdscript.grammar.ScriptLexer
import gdscript.grammar.ScriptLexer.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        if (tokenType !is TokenIElementType)
            pack(null)
        else
            pack(mapToColor(tokenType.antlrTokenType)?.textAttributesKey)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun mapToColor(tokenType: Int): ScriptColor? =
        when (tokenType) {
            NUMBER, HEX -> ScriptColor.NUMBER
            STRING -> ScriptColor.STRING
            IDENTIFIER -> ScriptColor.PARAMETER
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
            RETURN -> ScriptColor.KEYWORD
            LINE_COMMENT -> ScriptColor.LINE_COMMENT
            BLOCK_COMMENT -> ScriptColor.BLOCK_COMMENT
            else -> null
        }

}
























