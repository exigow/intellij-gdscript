package plugin.parser

import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath
import org.junit.Assert
import plugin.GDScript

class GDScriptParserDefinitionTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test var`() {
        val code = "var index = 7"
        assertXPathMatches(code, "/file/stmt/simple_stmt/primary/PARAMETER")
    }

    fun `test var primitive typed`() {
        val code = "var damage: float = 74.9"
        assertXPathMatches(code, "/file/stmt/simple_stmt/type")
    }

    fun `test var class typed`() {
        val code = "var color: String = \"blue\""
        assertXPathMatches(code, "/file/stmt/simple_stmt/primary")
        assertXPathMatches(code, "/file/stmt/simple_stmt/type")
    }

    fun `test function declaration with no arguments`() {
        val code = """
        func test():
            pass
        """
        assertXPathMatches(code, "/file/stmt/compound_stmt/suite/stmt/simple_stmt")
    }

    fun `test function declaration with multiple arguments`() {
        val code = """
        func test(a: int, b: Vector2):
            pass
        """
        assertXPathMatches(code, "/file/stmt/compound_stmt/parameter/type")
    }

    fun `test comment after statement`() {
        val code = "return 0 # comment"
        assertXPathMatches(code, "/file/stmt/simple_stmt")
    }

    fun `test comment`() {
        val code = "# comment"
        assertXPathMatches(code, "/file")
    }

    private fun assertXPathMatches(code: String, xpath: String) {
        myFile = createPsiFile("a", code.trimIndent())
        ensureParsed(myFile)
        val tree = ASTNodePrinter.build(myFile.node)
        val nodes = XPath.findAll(GDScript, myFile, xpath)
        if (nodes.isEmpty())
            Assert.fail("Unsatisfied selector '$xpath'\nCode:\n${myFile.text}\nTree:\n$tree")
        print(tree)
    }

}
