package gdscript

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.lexer.ScriptLexerAdapter
import gdscript.psi.ScriptElementTypes.*

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ScriptLexerAdapter()

    private fun matchingToColor(element: IElementType?) = when (element) {
        IF,
        EXPORT,
        ELIF,
        ELSE,
        FOR,
        WHILE,
        BREAK,
        CONTINUE,
        PASS,
        RETURN,
        MATCH,
        ASSERT,
        AWAIT,
        BREAKPOINT,
        CLASS,
        CLASS_NAME,
        CONST,
        ENUM,
        EXTENDS,
        FUNC,
        SELF,
        SIGNAL,
        STATIC,
        ONREADY,
        VAR,
        SETGET,
        YIELD,
        TRUE,
        FALSE,
        NULL,
        AND,
        OR,
        NOT,
        INT,
        FLOAT,
        BOOL,
        VOID,
        IN,
        IS,
        AS,
        TOOL,
        MASTER,
        PUPPET,
        REMOTE,
        SYNC,
        MASTERSYNC,
        PUPPETSYNC,
        REMOTESYNC -> Colors.KEYWORD

        LESS,
        LESS_EQUAL,
        GREATER,
        GREATER_EQUAL,
        EQUAL_EQUAL,
        BANG_EQUAL,
        AMPERSAND_AMPERSAND,
        PIPE_PIPE,
        BANG,
        AMPERSAND,
        PIPE,
        TILDE,
        CARET,
        LESS_LESS,
        GREATER_GREATER,
        PLUS,
        MINUS,
        STAR,
        SLASH,
        PERCENT,
        DOT_DOT,
        EQUAL,
        PLUS_EQUAL,
        MINUS_EQUAL,
        STAR_EQUAL,
        SLASH_EQUAL,
        PERCENT_EQUAL,
        LESS_LESS_EQUAL,
        GREATER_GREATER_EQUAL,
        AMPERSAND_EQUAL,
        PIPE_EQUAL,
        CARET_EQUAL,
        INFER,
        ARROW,
        UNDERSCORE -> Colors.OPERATION_SIGN

        DOUBLE_QUOTED_STRING,
        SINGLE_QUOTED_STRING,
        MULTILINE_DOUBLE_QUOTED_STRING,
        MULTILINE_SINGLE_QUOTED_STRING -> Colors.STRING

        REAL_NUMBER,
        BINARY_NUMBER,
        HEXADECIMAL_NUMBER -> Colors.NUMBER

        IDENTIFIER -> Colors.IDENTIFIER
        NODE_PATH -> Colors.NODE_PATH
        AT_ONREADY,
        AT_TOOL,
        AT_EXPORT,
        AT_ICON,
        AT_MASTER,
        AT_PUPPET,
        AT_REMOTE,
        AT_MASTERSYNC,
        AT_PUPPETSYNC,
        AT_REMOTESYNC -> Colors.ANNOTATION

        LINE_COMMENT -> Colors.LINE_COMMENT
        COMMA -> Colors.COMMA
        COLON -> Colors.COLON
        SEMICOLON -> Colors.SEMICOLON
        DOT -> Colors.DOT
        L_BRACE, R_BRACE -> Colors.BRACES
        L_PAREN, R_PAREN -> Colors.PARENTHESES
        L_BRACKET, R_BRACKET -> Colors.BRACKETS
        else -> null
    }

}
