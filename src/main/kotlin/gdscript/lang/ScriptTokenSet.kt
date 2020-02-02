package gdscript.lang

import gdscript.ScriptLexer.*
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object ScriptTokenSet {

    val KEYWORDS = create(*generateKeywordSet(), FUNCTION_IDENTIFIER)
    val WHITESPACES = create(WHITESPACE)
    val LINE_COMMENTS = create(LINE_COMMENT)
    val IDENTIFIERS = create(IDENTIFIER)
    val NODES = create(NODE)
    val COMMAS = create(COMMA)
    val SEMICOLONS = create(SEMICOLON)
    val COLONS = create(COLON)
    val ARROWS = create(ARROW)
    val DOTS = create(DOT)
    val NUMBERS = create(NUMBER)
    val STRINGS = create(STRING_DOUBLE_QUOTE, STRING_APHOSTROPHE, STRING_MULTILINE)
    val RESOURCES = create(RESOURCE, USER_RESOURCE)
    val CONSTANTS = create(CONSTANT_IDENTIFIER)
    val CLASSES = create(CLASS_IDENTIFIER)
    val OPERATION_SIGNS = create(
        ASSIGN,
        MINUS,
        OTHER_OPERATORS,
        COMPARE,
        NOT_BITWISE,
        NOT_BOOLEAN
    )
    val BRACES = create(
        BRACE_LEFT,
        BRACE_RIGHT
    )
    val PARENTHESES = create(
        PARENTHES_LEFT,
        PARENTHES_RIGHT
    )
    val BRACKETS = create(
        BRACKET_LEFT,
        BRACKET_RIGHT
    )

    private fun create(vararg token: Int) =
        createTokenSet(ScriptLanguage, *token)!!

    private fun generateKeywordSet() =
        (0..VOCABULARY.maxTokenType)
            .filter { VOCABULARY.getDisplayName(it).removeSurrounding("\'").matches("[a-z_]+".toRegex()) }
            .toIntArray()

}
