package plugin

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.TokenSet

object ASTNodePrinter {

    // GENERATED

    @JvmStatic
    fun printDirectoryTree(folder: ASTNode): String {
        val indent = 0
        val sb = StringBuilder()
        printDirectoryTree(folder, indent, sb)
        return sb.toString()
    }

    private fun printDirectoryTree(folder: ASTNode, indent: Int, sb: StringBuilder) {
        sb.append(getIndentString(indent))
        sb.append(toPrettyName(folder.psi.node.elementType.toString()))
        sb.append("\n")
        for (file in folder.getChildren(TokenSet.ANY))
            if (file.getChildren(TokenSet.ANY).size > 0)
                printDirectoryTree(file, indent + 1, sb)
            else
                printFile(file.text, indent + 1, sb)
    }

    private fun printFile(name: String, indent: Int, sb: StringBuilder) {
        sb.append(getIndentString(indent))
        sb.append(toPrettyName(name))
        sb.append("\n")
    }

    private fun getIndentString(indent: Int): String {
        val sb = StringBuilder()
        for (i in 0 until indent)
            sb.append("   ")
        return sb.toString()
    }

    private fun toPrettyName(name: String): String {
        if (name.length == 1) {
            val c = name[0]
            if (Character.isWhitespace(c))
                return Character.getName(c.toInt()).toLowerCase()
        }
        return name
    }

}
