package script.psi.elements

import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class FunctionPsiElement(node: ASTNode) : ANTLRPsiNode(node) {

    fun isStatic() = children.map { it.text }.contains("static")

}
