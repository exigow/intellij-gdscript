package plugin

import com.intellij.testFramework.ParsingTestCase
import org.antlr.intellij.adaptor.xpath.XPath
import org.junit.Assert

class GDScriptTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test var`() = assertXPathMatches(
        code = "var index = 7",
        xpath = "/file/stmt/simple_stmt/primary/PARAMETER"
    )

    fun `test var primitive typed`() = assertXPathMatches(
        code = "var damage: float = 74.9",
        xpath = "/file/stmt/simple_stmt/type"
    )

    fun `test var class typed`() = assertXPathMatches(
        code = "var color: String = \"blue\"",
        xpath = ""
    )

    fun `test function declaration with no arguments`() = assertXPathMatches(
        code = """
        func test():
            pass
        """,
        xpath = "/file/stmt/compound_stmt/suite/stmt/simple_stmt"
    )

    fun `test function declaration with multiple arguments`() = assertXPathMatches(
        code = """
        func test(a: int, b: Vector2):
            pass
        """,
        xpath = "/file/stmt/compound_stmt/parameter_list/parameter/type"
    )

    fun `test comment after statement`() = assertXPathMatches(
        code = "return 0 # comment",
        xpath = "/file/stmt/simple_stmt"
    )

    fun `test comment`() = assertXPathMatches(
        code = "# comment",
        xpath = "/file"
    )

    private fun assertXPathMatches(code: String, xpath: String) {
        myFile = createPsiFile("a", code.trimIndent())
        ensureParsed(myFile)
        val tree = ASTNodePrinter.build(myFile.node.psi.node)
        val nodes = XPath.findAll(GDScript, myFile, xpath)
        if (nodes.isEmpty())
            Assert.fail("Unsatisfied selector '$xpath'\nCode:\n${myFile.text}\nTree:\n$tree")
        print(tree)
    }

}
