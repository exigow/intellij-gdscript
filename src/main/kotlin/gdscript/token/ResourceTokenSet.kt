package gdscript.token

import ResourceLexer.*
import gdscript.parser.ResourceLanguage
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object ResourceTokenSet {

    val WHITESPACES = create(WHITESPACE)
    val KEYWORDS = create(TRUE, FALSE, NULL)
    val IDENTIFIERS = create(IDENTIFIER)
    val NUMBERS = create(NUMBER)
    val STRINGS = create(STRING_DOUBLE_QUOTE, STRING_APHOSTROPHE, STRING_MULTILINE)
    val RESOURCES = create(RESOURCE)
    val LINE_COMMENTS = create(LINE_COMMENT)

    private fun create(vararg token: Int) =
        createTokenSet(ResourceLanguage, *token)!!

}