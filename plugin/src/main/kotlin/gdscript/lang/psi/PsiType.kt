package gdscript.lang.psi

import GodotApi.PRIMITIVE_CLASSES
import com.intellij.lang.ASTNode
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class PsiType(node: ASTNode) : ANTLRPsiNode(node) {

    fun isNotPrimitive() = node.text !in PRIMITIVE_CLASSES.map { it.name }

}