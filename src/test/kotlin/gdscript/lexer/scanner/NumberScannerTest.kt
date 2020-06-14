package gdscript.lexer.scanner

import gdscript.ScriptTokenType.NUMBER
import gdscript.lexer.Token
import junit.framework.TestCase


class NumberScannerTest : TestCase() {

    fun `test integer`() {
        val token = NumberScanner().scanToken("45", 0)
        assertEquals(Token(0, 2, NUMBER), token)
    }

    fun `test integer with minus as whole number`( ){
        val token = NumberScanner().scanToken("-11", 0)
        assertEquals(Token(0, 3, NUMBER), token)
    }

    fun `test decimal`() {
        val scannedToken = NumberScanner().scanToken("3.1415", 0)
        assertEquals(Token(0, 6, NUMBER), scannedToken)
    }

    fun `test scientific`() {
        val scannedToken = NumberScanner().scanToken("58.1e-10", 0)
        assertEquals(Token(0, 8, NUMBER), scannedToken)
    }

    fun `test scientific short`() {
        val scannedToken = NumberScanner().scanToken("1e20", 0)
        assertEquals(Token(0, 4, NUMBER), scannedToken)
    }

    fun `test partially`( ){
        val token = NumberScanner().scanToken("123", start = 2)
        assertEquals(Token(2, 3, NUMBER), token)
    }

    fun `test surrounded by other tokens`( ){
        val token = NumberScanner().scanToken("x = 42.07 + y", start = 4)
        assertEquals(Token(4, 9, NUMBER), token)
    }

    fun `test null when not recognized`( ){
        val token: Token? = NumberScanner().scanToken("z", 0)
        assertNull(token)
    }

    fun `test skip scientific notation with no exponent`( ){
        val token = NumberScanner().scanToken("12.34e-", 0)
        assertEquals(Token(0, 5, NUMBER), token)
    }

}