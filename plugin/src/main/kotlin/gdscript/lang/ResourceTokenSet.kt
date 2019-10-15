package gdscript.lang

import gdscript.GDScriptResourceLexer
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object ResourceTokenSet {

    val WHITESPACE = createTokenSet(ResourceLanguage, GDScriptResourceLexer.WHITESPACE)!!
    val KEYWORD = createTokenSet(ResourceLanguage, GDScriptResourceLexer.KEYWORD)!!
    val IDENTIFIER = createTokenSet(ResourceLanguage, GDScriptResourceLexer.IDENTIFIER)!!
    val NUMBER = createTokenSet(ResourceLanguage, GDScriptResourceLexer.NUMBER)!!
    val STRING = createTokenSet(ResourceLanguage, GDScriptResourceLexer.STRING)!!
    val LINE_COMMENT = createTokenSet(ResourceLanguage, GDScriptResourceLexer.LINE_COMMENT)!!

}