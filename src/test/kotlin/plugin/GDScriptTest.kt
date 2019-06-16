package plugin

import com.intellij.psi.PsiElement
import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath

class GDScriptTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test variable definition`() {
        val psi = parse("var x = 1")
        assertSelectionExists(psi, "script/variable_definition")
    }

    fun `test expression statement`() {
        val psi = parse("a = 32")
        assertSelectionExists(psi, "script/statement/expression")
    }

    fun `test call function expression`() {
        val psi = parse("ping()")
        assertSelectionExists(psi, "script/statement/call_function_expression")
    }

    private fun parse(code: String): PsiElement {
        val file = createPsiFile("script.gd", code)
        ensureParsed(file)
        return file.node.lastChildNode.psi // skip file/root node
    }

    private fun assertSelectionExists(psi: PsiElement, selector: String) {
        println("PSI tree:\n${toPrettyTreeString(psi)}")
        val result = XPath.findAll(GDScript, psi, selector) // throws error when selection is invalid
        if (result.isEmpty())
            fail("Invalid selector $selector")
    }

    private fun toPrettyTreeString(psi: PsiElement) = ASTNodePrinter.printDirectoryTree(psi.node)

}
