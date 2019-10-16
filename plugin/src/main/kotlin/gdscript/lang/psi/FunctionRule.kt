package gdscript.lang.psi

import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class FunctionRule(node: ASTNode) : ANTLRPsiNode(node) {

    fun isStatic() = children.map { it.text }.contains("static")

}
