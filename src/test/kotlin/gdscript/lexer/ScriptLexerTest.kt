package gdscript.lexer

import ScriptLexer
import ScriptLexer.FUNCTION
import ScriptParser
import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import gdscript.lang.ScriptLanguage
import junit.framework.TestCase
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptLexerTest : TestCase() {

    fun `test preload function is tokenized as language level function`() {
        val tokens = collectTokens("var x = preload(1)")
        assertContainsElements(tokens, Token(FUNCTION, "preload"))
    }

    private fun collectTokens(code: String): List<Token> {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ScriptLanguage, ScriptParser.tokenNames, ScriptParser.ruleNames)
        val adaptor = ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))
        adaptor.start(code)
        val tokens = ArrayList<Token>()
        do {
            val lastType = adaptor.tokenType
                ?: return tokens
            val type = (lastType as TokenIElementType).antlrTokenType
            tokens.add(Token(type, adaptor.tokenText))
            adaptor.advance()
        } while (true)
    }

    private data class Token(val type: Int, val text: String)

}