package gdscript.parser

import BaseTest
import com.intellij.psi.impl.DebugUtil
import com.intellij.testFramework.ParsingTestCase
import com.jetbrains.rd.util.string.print
import junit.framework.TestCase
import utils.openScript

class ScriptParserTest : BaseTest() {

    fun `test two func statements`() {
        val code = """
            func x():
                pass
            
            
            func x():
                pass
            
        """.trimIndent()
        assertPsiEquals("""
            FILE
              ScriptFuncStatementImpl(FUNC_STATEMENT)
                PsiElement(func)('func')
                ScriptIdImpl(ID)
                  PsiElement(IDENTIFIER)('x')
                PsiElement(()('(')
                PsiElement())(')')
                PsiElement(:)(':')
                PsiElement(LINE_BREAK)('\n')
                ScriptBlockImpl(BLOCK)
                  PsiElement(pass)('pass')
                  PsiElement(LINE_BREAK)('\n')
              PsiElement(LINE_BREAK)('\n')
              PsiElement(LINE_BREAK)('\n')
              ScriptFuncStatementImpl(FUNC_STATEMENT)
                PsiElement(func)('func')
                ScriptIdImpl(ID)
                  PsiElement(IDENTIFIER)('x')
                PsiElement(()('(')
                PsiElement())(')')
                PsiElement(:)(':')
                PsiElement(LINE_BREAK)('\n')
                ScriptBlockImpl(BLOCK)
                  PsiElement(pass)('pass')
                  PsiElement(LINE_BREAK)('\n')
        """.trimIndent(), code)
    }


    fun `test func with if statement inside`() {
        val code = """
            func x():
                if y:
                    pass
            
        """.trimIndent()
        assertPsiEquals("""
            FILE
              ScriptFuncStatementImpl(FUNC_STATEMENT)
                PsiElement(func)('func')
                ScriptIdImpl(ID)
                  PsiElement(IDENTIFIER)('x')
                PsiElement(()('(')
                PsiElement())(')')
                PsiElement(:)(':')
                PsiElement(LINE_BREAK)('\n')
                ScriptBlockImpl(BLOCK)
                  ScriptIfStatementImpl(IF_STATEMENT)
                    PsiElement(if)('if')
                    ScriptExpressionImpl(EXPRESSION)
                      ScriptIdImpl(ID)
                        PsiElement(IDENTIFIER)('y')
                    PsiElement(:)(':')
                    PsiElement(LINE_BREAK)('\n')
                    ScriptBlockImpl(BLOCK)
                      PsiElement(pass)('pass')
                      PsiElement(LINE_BREAK)('\n')
        """.trimIndent(), code)
    }

    private fun assertPsiEquals(expectedPsi: String, actualCode: String) {
        val file = environment.openScript(actualCode)
        val actualPsi = DebugUtil.psiToString(file, true, false).trim()
        assertEquals(expectedPsi, actualPsi)
    }

}
