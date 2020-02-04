package utils

import com.intellij.lang.Language
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType

fun tokenize(language: Language, lexer: org.antlr.v4.runtime.Lexer, code: String): List<Token> {
    @Suppress("DEPRECATION")
    PSIElementTypeFactory.defineLanguageIElementTypes(language, lexer.tokenNames, lexer.ruleNames)
    val adaptor = ANTLRLexerAdaptor(language, lexer)
    adaptor.start(code)
    val tokens = ArrayList<Token>()
    do {
        val type = adaptor.tokenType as? TokenIElementType
            ?: return tokens
        tokens.add(Token(type.antlrTokenType, adaptor.tokenText))
        adaptor.advance()
    } while (true)
}

data class Token(val type: Int, val text: String)