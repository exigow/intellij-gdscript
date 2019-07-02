package plugin

import com.intellij.psi.PsiElement
import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath
import plugin.ASTNodePrinter.printDirectoryTree

class GDScriptTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test minimal`() {
        val psi = parse("one")
        assertSelectionExists(psi, "script/statement/simpleStatement/primary")
    }

    fun `test simple two newlines`() {
        val psi = parse("one\ntwo\n")
        assertSelectionExists(psi, "script/statement/simpleStatement/primary")
    }

    fun `test complex`() {
        val code =
            "hello\n" +
            "if test \"dolly\"\n" +
            "    17.512\n" +
            "    while test\n" +
            "        olla\n" +
            "        \"str\"\n" +
            "dolly"
        val psi = parse(code)
        assertSelectionExists(psi, "script/statement/simpleStatement/primary")
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
