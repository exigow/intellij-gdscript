package plugin

import com.intellij.psi.PsiElement
import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath
import plugin.ASTNodePrinter.printDirectoryTree

class GDScriptTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test complex`() {
        val psi = parse(
                "hello = 1\n" +
                "if (test) abc = \"words\"\n" +
                "function()\n")
        assertSelectionExists(psi, "script/statement/expression")
    }

    fun `test simple newlines`() {
        val psi = parse("one = 1")
        assertSelectionExists(psi, "script/statement/expression")
    }

    private fun parse(code: String): PsiElement {
        val file = createPsiFile("script.gd", code)
        ensureParsed(file)
        return file.node.psi
    }

    private fun assertSelectionExists(psi: PsiElement, selector: String) {
        println("PSI tree:\n${printDirectoryTree(psi.node)}")
        val result = XPath.findAll(GDScript, psi, selector) // throws error when selection is invalid
        if (result.isEmpty())
            fail("Invalid selector $selector")
    }

}
