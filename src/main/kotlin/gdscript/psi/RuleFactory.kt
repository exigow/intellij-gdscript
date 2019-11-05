package gdscript.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import ScriptParser.*
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

object RuleFactory {

    fun createPsiElement(node: ASTNode): PsiElement {
        val nodeType = node.elementType
        if (nodeType is RuleIElementType)
            return convertRuleIndexToPsi(nodeType.ruleIndex, node)
        return ANTLRPsiNode(node)
    }

    private fun convertRuleIndexToPsi(index: Int, node: ASTNode) =
        when(index) {
            RULE_type -> TypeRule(node)
            RULE_primary -> PrimaryRule(node)
            RULE_func_line -> FunctionRule(node)
            RULE_instance_field_expression -> InstanceFieldRule(node)
            else -> ANTLRPsiNode(node)
        }

}
