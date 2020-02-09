package gdscript

import gdscript.ScriptLexer.*
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object ScriptTokenSet {

    val KEYWORDS = create(SYNC, MATCH, EXPORT, ONREADY, VAR, SETGET, CONST,
        STATIC, FUNC, FOR, WHILE, CLASS, EXTENDS, CLASS_NAME, ENUM, IF, ELIF,
        ELSE, RETURN, PASS, TOOL, SIGNAL, BREAK, CONTINUE, NOT, IS_AS_IN_AND_OR,
        TRUE_FALSE_SELF_NULL, BOOL_INT_FLOAT_VOID, FUNCTION_IDENTIFIER)
    val WHITESPACES = create(WHITESPACE)
    val LINE_COMMENTS = create(LINE_COMMENT)
    val IDENTIFIERS = create(IDENTIFIER)
    val NODES = create(NODE)
    val COMMAS = create(COMMA)
    val SEMICOLONS = create(SEMICOLON)
    val COLONS = create(COLON)
    val DOTS = create(DOT)
    val NUMBERS = create(NUMBER)
    val STRINGS = create(STRING_DOUBLE_QUOTE, STRING_APHOSTROPHE, STRING_MULTILINE)
    val RESOURCES = create(RESOURCE, USER_RESOURCE)
    val CONSTANTS = create(CONSTANT_IDENTIFIER)
    val CLASSES = create(CLASS_IDENTIFIER)
    val OPERATION_SIGNS = create(
        ARROW,
        MINUS,
        OPERATOR,
        NOT_BITWISE,
        NOT_BOOLEAN
    )
    val BRACES = create(
        BRACE_OPEN,
        BRACE_CLOSE
    )
    val PARENTHESES = create(
        PARENTHES_OPEN,
        PARENTHES_CLOSE
    )
    val BRACKETS = create(
        BRACKET_OPEN,
        BRACKET_CLOSE
    )

    private fun create(vararg token: Int) =
        createTokenSet(ScriptLanguage, *token)!!

}
