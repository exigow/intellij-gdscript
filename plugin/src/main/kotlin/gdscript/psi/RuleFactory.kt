package gdscript.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import gdscript.GDScriptParser.*
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
            RULE_value -> ValueRule(node)
            RULE_invoke -> InvokeRule(node)
            RULE_func_statement -> FunctionRule(node)
            else -> ANTLRPsiNode(node)
        }

}
