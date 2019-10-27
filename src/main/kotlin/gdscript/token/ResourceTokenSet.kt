package gdscript.token

import ResourceLexer.*
import gdscript.parser.ResourceLanguage
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object ResourceTokenSet {

    val WHITESPACES = create(WHITESPACE)
    val KEYWORDS = create(KEYWORD)
    val IDENTIFIERS = create(IDENTIFIER)
    val NUMBERS = create(NUMBER)
    val STRINGS = create(STRING)
    val LINE_COMMENTS = create(LINE_COMMENT)

    private fun create(vararg token: Int) =
        createTokenSet(ResourceLanguage, *token)!!

}