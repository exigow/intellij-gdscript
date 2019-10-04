package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import script.grammar.ScriptLexer
import script.grammar.ScriptLexer.*
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        if (element !is TokenIElementType)
            pack(null)
        else pack(getColor(element.antlrTokenType))

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun getColor(tokenType: Int) = when (tokenType) {
        NUMBER -> ScriptHighlighterColors.NUMBER
        STRING,
        MULTILINE_STRING -> ScriptHighlighterColors.STRING
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
        OPERATION_KEYWORD,
        TYPE_KEYWORD,
        NOT_KEYWORD,
        VALUE_KEYWORD -> ScriptHighlighterColors.KEYWORD
        METADATA -> ScriptHighlighterColors.METADATA
        IDENTIFIER -> ScriptHighlighterColors.IDENTIFIER
        ARROW,
        ASSIGN_SIGN,
        OPERATION_SIGN -> ScriptHighlighterColors.OPERATION_SIGN
        COMMA -> ScriptHighlighterColors.COMMA
        DOT -> ScriptHighlighterColors.DOT
        BRACE_LEFT,
        BRACE_RIGHT -> ScriptHighlighterColors.BRACES
        PARENTHES_LEFT,
        PARENTHES_RIGHT -> ScriptHighlighterColors.PARENTHESES
        BRACKET_LEFT,
        BRACKET_RIGHT -> ScriptHighlighterColors.BRACKETS
        LINE_COMMENT -> ScriptHighlighterColors.LINE_COMMENT
        else -> null
    }

}
