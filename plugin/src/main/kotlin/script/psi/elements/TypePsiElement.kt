package script.psi.elements

import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class TypePsiElement(node: ASTNode) : ANTLRPsiNode(node) {

    fun isNotPrimitive() = node.text !in listOf("bool", "int", "float", "void")

}