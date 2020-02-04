package scene

import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import scene.ResourceLexer.*

object ResourceTokenSet {

    val WHITESPACES = create(WHITESPACE)
    val KEYWORDS = create(KEYWORD)
    val IDENTIFIERS = create(IDENTIFIER)
    val NUMBERS = create(NUMBER)
    val STRINGS = create(STRING)
    val RESOURCES = create(RESOURCE)
    val LINE_COMMENTS = create(LINE_COMMENT)

    private fun create(vararg token: Int) =
        createTokenSet(ResourceLanguage, *token)!!

}