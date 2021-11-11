package gdscript.lexer

import BaseTest
import com.intellij.testFramework.LexerTestCase

class ScriptLexerAdapterTest : BaseTest() {

    fun `test identifier`() {
        assertTokenEquals("IDENTIFIER ('_x')", "_x")
        assertTokenEquals("IDENTIFIER ('position_2')", "position_2")
        assertTokenEquals("IDENTIFIER ('SomeClass')", "SomeClass")
        assertTokenEquals("IDENTIFIER ('UPPER_CASE')", "UPPER_CASE")
    }

    fun `test node path`() {
        assertTokenEquals("NODE_PATH ('\$MyNode')", "\$MyNode")
        assertTokenEquals("NODE_PATH ('\$Outer/Inner')", "\$Outer/Inner")
        assertTokenEquals("NODE_PATH ('\$\"../BodyPivot\"')", "\$\"../BodyPivot\"")
    }

    fun `test real number`() {
        assertTokenEquals("REAL_NUMBER ('3.14')", "3.14")
        assertTokenEquals("REAL_NUMBER ('3.141_592_7')", "3.141_592_7")
        assertTokenEquals("REAL_NUMBER ('58.1e-10')", "58.1e-10")
        assertTokenEquals("REAL_NUMBER ('1e10')", "1e10")
        assertTokenEquals("REAL_NUMBER ('.01')", ".01")
        assertTokenEquals("REAL_NUMBER ('1.')", "1.")
    }

    fun `test hexadecimal number`() {
        assertTokenEquals("HEXADECIMAL_NUMBER ('0x')", "0x")
        assertTokenEquals("HEXADECIMAL_NUMBER ('0x8f51')", "0x8f51")
        assertTokenEquals("HEXADECIMAL_NUMBER ('0x8080_0000_ffff')", "0x8080_0000_ffff")
    }

    fun `test binary number`() {
        assertTokenEquals("BINARY_NUMBER ('0b')", "0b")
        assertTokenEquals("BINARY_NUMBER ('0b101010')", "0b101010")
        assertTokenEquals("BINARY_NUMBER ('0b11_00_11_00')", "0b11_00_11_00")
    }

    fun `test double quoted string`() {
        assertTokenEquals("DOUBLE_QUOTED_STRING ('\"\"')", "\"\"")
        assertTokenEquals("DOUBLE_QUOTED_STRING ('\"aaa\"')", "\"aaa\"")
    }

    fun `test single quoted string`() {
        assertTokenEquals("SINGLE_QUOTED_STRING ('''')", "''")
        assertTokenEquals("SINGLE_QUOTED_STRING (''aaa'')", "'aaa'")
    }

    fun `test unfinished string to line break`() {
        val expected = "DOUBLE_QUOTED_STRING ('\"a')\n" +
            "LINE_BREAK ('\\n')"
        assertTokenEquals(expected, "\"a\n")
    }

    fun `test multiline double quoted string`() {
        assertTokenEquals("MULTILINE_DOUBLE_QUOTED_STRING ('\"\"\"abc\"\"\"')", "\"\"\"abc\"\"\"")
        assertTokenEquals("MULTILINE_DOUBLE_QUOTED_STRING ('\"\"\"\\nabc\\n\"\"\"')", "\"\"\"\nabc\n\"\"\"")
    }

    fun `test multiline single quoted string`() {
        assertTokenEquals("MULTILINE_SINGLE_QUOTED_STRING ('\'\'\'abc\'\'\'')", "\'\'\'abc\'\'\'")
        assertTokenEquals("MULTILINE_SINGLE_QUOTED_STRING ('\'\'\'\\nabc\\n\'\'\'')", "\'\'\'\nabc\n\'\'\'")
    }

    private fun assertTokenEquals(expected: String, code: String) {
        val adapter = ScriptLexerAdapter()
        val printed = LexerTestCase.printTokens(code, 0, adapter).trim()
        assertEquals(expected, printed)
    }

}
