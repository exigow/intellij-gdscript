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
        else pack(getColor(element.antlrTokenType)?.key)

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun getColor(tokenType: Int) = when (tokenType) {
        NUMBER -> ScriptColor.NUMBER
        STRING,
        MULTILINE_STRING -> ScriptColor.STRING
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
        AND,
        OR,
        IN,
        IS,
        AS,
        NOT,
        TRUE,
        FALSE,
        SELF,
        BOOL,
        INT,
        FLOAT,
        VOID -> ScriptColor.KEYWORD
        NODE -> ScriptColor.NODE
        IDENTIFIER -> ScriptColor.IDENTIFIER
        ARROW,
        MINUS,
        ASSIGN,
        ASSIGN_SPECIAL,
        OPERATION_SIGN -> ScriptColor.OPERATION_SIGN
        COMMA -> ScriptColor.COMMA
        DOT -> ScriptColor.DOT
        BRACE_LEFT,
        BRACE_RIGHT -> ScriptColor.BRACES
        PARENTHES_LEFT,
        PARENTHES_RIGHT -> ScriptColor.PARENTHESES
        BRACKET_LEFT,
        BRACKET_RIGHT -> ScriptColor.BRACKETS
        LINE_COMMENT -> ScriptColor.LINE_COMMENT
        else -> null
    }

}
