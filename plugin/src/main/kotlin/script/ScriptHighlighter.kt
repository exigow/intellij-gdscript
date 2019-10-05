package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import script.colors.ScriptColor
import script.grammar.ScriptLexer
import script.grammar.ScriptLexer.*

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        if (element !is TokenIElementType)
            pack(null)
        else pack(getColor(element.antlrTokenType))

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun getColor(tokenType: Int) = when (tokenType) {
        NUMBER -> ScriptColor.NUMBER.key
        STRING,
        MULTILINE_STRING -> ScriptColor.STRING.key
        EXPORT,
        ONREADY,
        VAR,
        SETGET,
        CONST,
        STATIC,
        FUNC,
        FOR,
        WHILE,
        CLASS,
        EXTENDS,
        CLASS_NAME,
        ENUM,
        IF,
        ELIF,
        ELSE,
        RETURN,
        PASS,
        SIGNAL,
        OPERATION_KEYWORD,
        NOT_KEYWORD,
        VALUE_KEYWORD -> ScriptColor.KEYWORD.key
        METADATA -> ScriptColor.NODE_PATH.key
        IDENTIFIER -> ScriptColor.IDENTIFIER.key
        ARROW,
        MINUS,
        ASSIGN_SIGN,
        OPERATION_SIGN -> ScriptColor.OPERATION_SIGN.key
        COMMA -> ScriptColor.COMMA.key
        DOT -> ScriptColor.DOT.key
        BRACE_LEFT,
        BRACE_RIGHT -> ScriptColor.BRACES.key
        PARENTHES_LEFT,
        PARENTHES_RIGHT -> ScriptColor.PARENTHESES.key
        BRACKET_LEFT,
        BRACKET_RIGHT -> ScriptColor.BRACKETS.key
        LINE_COMMENT -> ScriptColor.LINE_COMMENT.key
        else -> null
    }

}
