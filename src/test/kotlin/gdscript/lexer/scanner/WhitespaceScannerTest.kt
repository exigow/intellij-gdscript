package gdscript.lexer.scanner

import gdscript.ScriptTokenType.WHITESPACE
import gdscript.lexer.Token
import junit.framework.TestCase


class WhitespaceScannerTest : TestCase() {

    fun `test single whitespace`() {
        val whitespace = WhitespaceScanner().scanToken(" ", 0)
        assertEquals(Token(0, 1, WHITESPACE), whitespace)
    }

    fun `test multiple whitespaces`() {
        val whitespace = WhitespaceScanner().scanToken("   ", 0)
        assertEquals(Token(0, 3, WHITESPACE), whitespace)
    }

    fun `test whitespace before word`() {
        val whitespace = WhitespaceScanner().scanToken("a b", 1)
        assertEquals(Token(1, 2, WHITESPACE), whitespace)
    }

}