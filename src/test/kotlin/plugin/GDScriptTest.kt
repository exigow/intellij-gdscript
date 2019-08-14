package plugin

import com.intellij.psi.PsiElement
import com.intellij.testFramework.ParsingTestCase
import plugin.ASTNodePrinter.printDirectoryTree

class GDScriptTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test var`() {
        val psi = parse("var z = 1")
        println(printDirectoryTree(psi.node))
    }

    fun `test function declaration with no arguments`() {
        val psi = parseMultiline("""
        func test():
            pass
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test function declaration with single argument`() {
        val psi = parseMultiline("""
        func test(a: bool):
            pass
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test function declaration with multiple arguments`() {
        val psi = parseMultiline("""
        func test(a: int, b: float):
            pass
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test function declaration with class-typed argument`() {
        val psi = parseMultiline("""
        func test(a: Vector2):
            pass
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test single line comment after statement`() {
        val psi = parse("return 0 # Comment after statement")
        println(printDirectoryTree(psi.node))
    }

    fun `test single line comment on empty line`() {
        val psi = parse("# Comment on empty line")
        println(printDirectoryTree(psi.node))
    }

    private fun parseMultiline(code: String) = parse(code.trimIndent())

    private fun parse(code: String): PsiElement {
        val file = createPsiFile("script.gd", code)
        ensureParsed(file)
        return file.node.psi
    }

}
