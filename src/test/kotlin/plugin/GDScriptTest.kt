package plugin

import com.intellij.psi.PsiElement
import com.intellij.testFramework.ParsingTestCase
import plugin.ASTNodePrinter.printDirectoryTree

class GDScriptTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test complex`() {
        val code =
                "extends BaseClass\n" +
                        "var kek = 123\n" +
                        "two\n" +
                        "if hello:\n" +
                        "\tfirst\n" +
                        "while \"dupaaa\":\n" +
                        "\tsecond\n" +
                        "\tdupa\n" +
                        "zero\n" +
                        "func test(a: float, b, c):\n" +
                        "\tvar k = 0"
        print(code)
        val psi = parse(code)
        println(printDirectoryTree(psi.node))
    }

    fun `test function declaration with empty args`() {
        val psi = parse("""
        func test():
            pass
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test function declaration with one arg`() {
        val psi = parse("""
        func test(a: bool):
            pass
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test function declaration with multiple args`() {
        val psi = parse("""
        func test(a: int, b: float):
            pass
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test single line comment after statement`() {
        val psi = parse("""
        pass # Comment after statement
        """)
        println(printDirectoryTree(psi.node))
    }

    fun `test single line comment on empty line`() {
        val psi = parse("""
        # Comment on empty line
        """)
        println(printDirectoryTree(psi.node))
    }

    private fun parse(code: String): PsiElement {
        val trimmed = code.trimIndent()
        val file = createPsiFile("script.gd", trimmed)
        ensureParsed(file)
        return file.node.psi
    }

}
