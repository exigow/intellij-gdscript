package gdscript.token

import gdscript.GDScriptLexer.*
import gdscript.parser.ScriptLanguage
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object ScriptTokenSet {

    val KEYWORDS = create(*generateKeywordSet())
    val WHITESPACES = create(WHITESPACE)
    val LINE_COMMENTS = create(LINE_COMMENT)
    val IDENTIFIERS = create(IDENTIFIER)
    val NODES = create(NODE)
    val COMMAS = create(COMMA)
    val SEMICOLONS = create(SEMICOLON)
    val DOTS = create(DOT)
    val NUMBERS = create(
        NUMBER_FLOATING,
        NUMBER_HEXADECIMAL,
        NUMBER_BINARY
    )
    val STRINGS = create(
        STRING,
        STRING_APHOSTROPHE,
        STRING_MULTILINE
    )
    val OPERATION_SIGNS = create(
        ASSIGN,
        ARROW,
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
