package gdscript.lexer

import com.intellij.testFramework.LexerTestCase
import junit.framework.TestCase

class ScriptLexerAdapterTest : TestCase() {

    fun `test var statement`() {
        val code = "var x = 0"
        assertTokensEquals("""
            var ('var')
            WHITE_SPACE (' ')
            IDENTIFIER ('x')
            WHITE_SPACE (' ')
            = ('=')
            WHITE_SPACE (' ')
            REAL_NUMBER ('0')
        """.trimIndent(), code)
    }

    fun `test identifier`() {
        assertTokensEquals("IDENTIFIER ('_x')", "_x")
        assertTokensEquals("IDENTIFIER ('position_2')", "position_2")
        assertTokensEquals("IDENTIFIER ('SomeClass')", "SomeClass")
        assertTokensEquals("IDENTIFIER ('UPPER_CASE')", "UPPER_CASE")
    }

    fun `test node path`() {
        assertTokensEquals("NODE_PATH ('\$MyNode')", "\$MyNode")
        assertTokensEquals("NODE_PATH ('\$Outer/Inner')", "\$Outer/Inner")
        assertTokensEquals("NODE_PATH ('\$\"../BodyPivot\"')", "\$\"../BodyPivot\"")
    }

    fun `test real number`() {
        assertTokensEquals("REAL_NUMBER ('3.14')", "3.14")
        assertTokensEquals("REAL_NUMBER ('3.141_592_7')", "3.141_592_7")
        assertTokensEquals("REAL_NUMBER ('58.1e-10')", "58.1e-10")
        assertTokensEquals("REAL_NUMBER ('1e10')", "1e10")
        assertTokensEquals("REAL_NUMBER ('.01')", ".01")
        assertTokensEquals("REAL_NUMBER ('1.')", "1.")
    }

    fun `test hexadecimal number`() {
        assertTokensEquals("HEXADECIMAL_NUMBER ('0x')", "0x")
        assertTokensEquals("HEXADECIMAL_NUMBER ('0x8f51')", "0x8f51")
        assertTokensEquals("HEXADECIMAL_NUMBER ('0x8080_0000_ffff')", "0x8080_0000_ffff")
    }

    fun `test binary number`() {
        assertTokensEquals("BINARY_NUMBER ('0b')", "0b")
        assertTokensEquals("BINARY_NUMBER ('0b101010')", "0b101010")
        assertTokensEquals("BINARY_NUMBER ('0b11_00_11_00')", "0b11_00_11_00")
    }

    fun `test double quoted string`() {
        assertTokensEquals("DOUBLE_QUOTED_STRING ('\"\"')", "\"\"")
        assertTokensEquals("DOUBLE_QUOTED_STRING ('\"aaa\"')", "\"aaa\"")
    }

    fun `test single quoted string`() {
        assertTokensEquals("SINGLE_QUOTED_STRING ('''')", "''")
        assertTokensEquals("SINGLE_QUOTED_STRING (''aaa'')", "'aaa'")
    }

    fun `test unfinished string to line break`() {
        val expected = "DOUBLE_QUOTED_STRING ('\"a')\n" +
            "LINE_BREAK ('\\n')"
        assertTokensEquals(expected, "\"a\n")
    }

    fun `test multiline double quoted string`() {
        assertTokensEquals("MULTILINE_DOUBLE_QUOTED_STRING ('\"\"\"abc\"\"\"')", "\"\"\"abc\"\"\"")
        assertTokensEquals("MULTILINE_DOUBLE_QUOTED_STRING ('\"\"\"\\nabc\\n\"\"\"')", "\"\"\"\nabc\n\"\"\"")
    }

    fun `test multiline single quoted string`() {
        assertTokensEquals("MULTILINE_SINGLE_QUOTED_STRING ('\'\'\'abc\'\'\'')", "\'\'\'abc\'\'\'")
        assertTokensEquals("MULTILINE_SINGLE_QUOTED_STRING ('\'\'\'\\nabc\\n\'\'\'')", "\'\'\'\nabc\n\'\'\'")
    }

    private fun assertTokensEquals(expectedTokens: String, actualCode: String) {
        val actualTokens = LexerTestCase.printTokens(actualCode, 0, ScriptLexerAdapter()).trim()
        assertEquals(expectedTokens, actualTokens)
    }

}
