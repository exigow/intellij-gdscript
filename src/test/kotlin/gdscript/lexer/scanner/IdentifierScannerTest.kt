package gdscript.lexer.scanner

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

}