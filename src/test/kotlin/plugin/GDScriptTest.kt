package plugin

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.TokenSet
import com.intellij.testFramework.ParsingTestCase

class GDScriptTest : ParsingTestCase("", "GDScript", GDScriptParserDefinition()) {

    fun `test single var definition`() {
        val tree = convertToSyntaxTree("var x = 1")
        printTree(tree)
    }

    fun `test multiple var definitions`() {
        val tree = convertToSyntaxTree("var x = 1\nvar y = 2")
        printTree(tree)
    }

    private fun convertToSyntaxTree(code: String): ASTNode {
        val file = createPsiFile("script.gd", code)
        ensureParsed(file)
        return file.node.getChildren(TokenSet.ANY)[0]
    }

    private fun printTree(tree: ASTNode) {
        val toShow = ASTNodePrinter.printDirectoryTree(tree)
        println(toShow)
    }

}
