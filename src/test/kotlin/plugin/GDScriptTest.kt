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
            "zero\n"
        print(code)
        val psi = parse(code)
        println(printDirectoryTree(psi.node))
    }

    fun `test comment`() {
        val code =
            "one\n" +
            "two # comment\n" +
            "zero\n"
        print(code)
        val psi = parse(code)
        println(printDirectoryTree(psi.node))
    }

    private fun parse(code: String): PsiElement {
        val file = createPsiFile("script.gd", code)
        ensureParsed(file)
        return file.node.psi
    }

}
