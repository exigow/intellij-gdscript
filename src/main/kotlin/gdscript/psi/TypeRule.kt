package gdscript.psi

import gdscript.completion.sources.CompletionData.PRIMITIVE_CLASSES
import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class TypeRule(node: ASTNode) : ANTLRPsiNode(node) {

    fun isNotPrimitive() = node.text !in PRIMITIVE_CLASSES.map { it.name }

}