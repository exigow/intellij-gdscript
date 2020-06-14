package gdscript.lexer.scanner

import gdscript.ScriptTokenType.CONSTANT
import gdscript.ScriptTokenType.IDENTIFIER
import gdscript.ScriptTokenType.KEYWORD
import gdscript.lexer.Token
import junit.framework.TestCase

class IdentifierScannerTest : TestCase() {

    fun `test identifier with underscore`() {
        val token = IdentifierScanner().scanToken("var my_id", start = 4)
        assertEquals(Token(4, 9, IDENTIFIER), token)
    }

    fun `test identifier single character`() {
        val token = IdentifierScanner().scanToken("x", 0)
        assertEquals(Token(0, 1, IDENTIFIER), token)
    }

    fun `test identifier underscore prefix`() {
        val token = IdentifierScanner().scanToken("_id", 0)
        assertEquals(Token(0, 3, IDENTIFIER), token)
    }

    fun `test var keyword`() {
        val token = IdentifierScanner().scanToken("var", 0)
        assertEquals(Token(0, 3, KEYWORD), token)
    }

    fun `test constant identifier`() {
        val token = IdentifierScanner().scanToken("const NUMBER = 42", start = 6)
        assertEquals(Token(6, 12, CONSTANT), token)
    }

    fun `test constant identifier with underscore`() {
        val token = IdentifierScanner().scanToken("const MAX_HEALTH = 100", start = 6)
        assertEquals(Token(6, 16, CONSTANT), token)
    }

    fun `test constant identifier with number`() {
        val token = IdentifierScanner().scanToken("const PLAYER_2 = 0", start = 6)
        assertEquals(Token(6, 14, CONSTANT), token)
    }

    fun `test match wildcard underscore is not constant but identifier`() {
        val token = IdentifierScanner().scanToken("_:", 0)
        assertEquals(Token(0, 1, IDENTIFIER), token)
    }

}