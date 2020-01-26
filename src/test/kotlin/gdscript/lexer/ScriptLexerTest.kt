package gdscript.lexer

import ScriptLexer
import ScriptLexer.*
import ScriptParser
import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import gdscript.lang.ScriptLanguage
import junit.framework.TestCase
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptLexerTest : TestCase() {

    fun `test var keyword`() =
        assertHasToken("var x", Token(VAR, "var"))

    fun `test string`() =
        assertHasToken("x = \"text\"", Token(STRING_DOUBLE_QUOTE, "\"text\""))

    fun `test string apostrophe`() =
        assertHasToken("x = 'text'", Token(STRING_APHOSTROPHE, "'text'"))

    fun `test identifier`() =
        assertHasToken("var name = 1", Token(IDENTIFIER, "name"))

    fun `test language function`() =
        assertHasToken("x = preload(1)", Token(FUNCTION, "preload"))

    fun `test resource`() =
        assertHasToken("x = \"res://file.gd\"", Token(RESOURCE, "\"res://file.gd\""))

    fun `test user resource`() =
        assertHasToken("x = \"user://save.txt\"", Token(USER_RESOURCE, "\"user://save.txt\""))

    fun `test node`() =
        assertHasToken("\$Some/Node", Token(NODE, "\$Some/Node"))

    private fun assertHasToken(code: String, expectedToken: Token) =
        assertContainsElements(tokenize(code), expectedToken)

    private fun tokenize(code: String): List<Token> {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ScriptLanguage, ScriptParser.tokenNames, ScriptParser.ruleNames)
        val adaptor = ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))
        adaptor.start(code)
        val tokens = ArrayList<Token>()
        do {
            val type = adaptor.tokenType as? TokenIElementType
                ?: return tokens
            tokens.add(Token(type.antlrTokenType, adaptor.tokenText))
            adaptor.advance()
        } while (true)
    }

    private data class Token(val type: Int, val text: String)

}