package gdscript.lexer

import com.intellij.testFramework.LexerTestCase
import junit.framework.TestCase

class ScriptIndentLexerTest : TestCase() {

    fun `test class with var and func`() {
        val code = """
            class Xyz:
                var x = 1
                func y():
                    return 2
            
        """.trimIndent()
        assertTokensEquals("""
            class ('class')
            WHITE_SPACE (' ')
            IDENTIFIER ('Xyz')
            : (':')
            LINE_BREAK ('\n')
            INDENT ('')
            WHITE_SPACE ('    ')
            var ('var')
            WHITE_SPACE (' ')
            IDENTIFIER ('x')
            WHITE_SPACE (' ')
            = ('=')
            WHITE_SPACE (' ')
            REAL_NUMBER ('1')
            LINE_BREAK ('\n')
            WHITE_SPACE ('    ')
            func ('func')
            WHITE_SPACE (' ')
            IDENTIFIER ('y')
            ( ('(')
            ) (')')
            : (':')
            LINE_BREAK ('\n')
            INDENT ('')
            WHITE_SPACE ('        ')
            return ('return')
            WHITE_SPACE (' ')
            REAL_NUMBER ('2')
            LINE_BREAK ('\n')
            DEDENT ('')
            DEDENT ('')
        """.trimIndent(), code)
    }

    fun `test func with indent`() {
        val code = """
            func x():
                pass
        """.trimIndent()
        assertTokensEquals("""
            func ('func')
            WHITE_SPACE (' ')
            IDENTIFIER ('x')
            ( ('(')
            ) (')')
            : (':')
            LINE_BREAK ('\n')
            INDENT ('')
            WHITE_SPACE ('    ')
            pass ('pass')
            DEDENT ('')
        """.trimIndent(), code)
    }

    fun `test spaces between two functions`() {
        val code = """
            func x():
                pass
            
            
            func y():
                pass
        """.trimIndent()
        assertTokensEquals("""
            func ('func')
            WHITE_SPACE (' ')
            IDENTIFIER ('x')
            ( ('(')
            ) (')')
            : (':')
            LINE_BREAK ('\n')
            INDENT ('')
            WHITE_SPACE ('    ')
            pass ('pass')
            LINE_BREAK ('\n')
            DEDENT ('')
            LINE_BREAK ('\n')
            LINE_BREAK ('\n')
            func ('func')
            WHITE_SPACE (' ')
            IDENTIFIER ('y')
            ( ('(')
            ) (')')
            : (':')
            LINE_BREAK ('\n')
            INDENT ('')
            WHITE_SPACE ('    ')
            pass ('pass')
            DEDENT ('')
        """.trimIndent(), code)
    }

    fun `test var`() {
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

    fun `test multiline nested arrays don't produce indents`() {
        val code = """
            var x = [
                (1), 
                {2}
            ]
        """.trimIndent()
        assertTokensEquals("""
            var ('var')
            WHITE_SPACE (' ')
            IDENTIFIER ('x')
            WHITE_SPACE (' ')
            = ('=')
            WHITE_SPACE (' ')
            [ ('[')
            LINE_BREAK ('\n')
            WHITE_SPACE ('    ')
            ( ('(')
            REAL_NUMBER ('1')
            ) (')')
            , (',')
            WHITE_SPACE (' ')
            LINE_BREAK ('\n')
            WHITE_SPACE ('    ')
            { ('{')
            REAL_NUMBER ('2')
            } ('}')
            LINE_BREAK ('\n')
            ] (']')
        """.trimIndent(), code)
    }

    private fun assertTokensEquals(expectedTokens: String, actualCode: String) {
        val actualTokens = LexerTestCase.printTokens(actualCode, 0, ScriptIndentLexer()).trim()
        assertEquals(expectedTokens, actualTokens)
    }

}