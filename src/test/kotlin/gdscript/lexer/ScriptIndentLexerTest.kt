package gdscript.lexer

import com.intellij.testFramework.LexerTestCase
import junit.framework.TestCase

class ScriptIndentLexerTest : TestCase() {

    fun `test indent`() {
        val lexer = ScriptIndentLexer()
        val code = """
            a
            b
                c
                d
            ${"\t\t"}e
                    f
                g
            h
        """.trimIndent()
        val printed = LexerTestCase.printTokens(code, 0, lexer)
        println(printed)
//        assertEquals(expected, printed)
    }

}