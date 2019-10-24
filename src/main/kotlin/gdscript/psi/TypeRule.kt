package gdscript.psi

import com.intellij.lang.ASTNode
import gdscript.completion.sources.COMPLETION_DATA
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class TypeRule(node: ASTNode) : ANTLRPsiNode(node) {

    fun isNotPrimitive() = node.text !in COMPLETION_DATA.primitiveClasses.map { it.name }

}