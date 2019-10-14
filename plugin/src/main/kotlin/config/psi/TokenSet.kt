package config.psi

import config.ConfigLanguage
import config.grammar.ConfigLexer
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object TokenSet {

    val WHITESPACE = createTokenSet(ConfigLanguage, ConfigLexer.WHITESPACE)!!
    val KEYWORD = createTokenSet(ConfigLanguage, ConfigLexer.KEYWORD)!!
    val IDENTIFIER = createTokenSet(ConfigLanguage, ConfigLexer.IDENTIFIER)!!
    val NUMBER = createTokenSet(ConfigLanguage, ConfigLexer.NUMBER)!!
    val STRING = createTokenSet(ConfigLanguage, ConfigLexer.STRING)!!
    val LINE_COMMENT = createTokenSet(ConfigLanguage, ConfigLexer.LINE_COMMENT)!!

}