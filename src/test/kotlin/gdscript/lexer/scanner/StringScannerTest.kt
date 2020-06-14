package gdscript.lexer.scanner

import gdscript.ScriptTokenType.DOUBLE_QUOTED_STRING
import gdscript.ScriptTokenType.SINGLE_QUOTED_STRING
import gdscript.lexer.Token
import junit.framework.TestCase

class StringScannerTest : TestCase() {

    fun `test double quote`() {
        val token = StringScanner().scanToken("\"abc\"", 0)
        assertEquals(Token(0, 5, DOUBLE_QUOTED_STRING), token)
    }

    fun `test not finished double quote`() {
        val token = StringScanner().scanToken("\"abc", 0)
        assertEquals(Token(0, 4, DOUBLE_QUOTED_STRING), token)
    }

    fun `test not finished double quote to end of line`() {
        val token = StringScanner().scanToken("\"abc\n", 0)
        assertEquals(Token(0, 4, DOUBLE_QUOTED_STRING), token)
    }

    fun `test single quote`() {
        val token = StringScanner().scanToken("'abc'", 0)
        assertEquals(Token(0, 5, SINGLE_QUOTED_STRING), token)
    }

    fun `test not finished single quote`() {
        val token = StringScanner().scanToken("'abc", 0)
        assertEquals(Token(0, 4, SINGLE_QUOTED_STRING), token)
    }

    fun `test not finished single quote to end of line`() {
        val token = StringScanner().scanToken("'abc\n", 0)
        assertEquals(Token(0, 4, SINGLE_QUOTED_STRING), token)
    }

}