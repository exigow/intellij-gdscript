package script.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import script.grammar.ScriptParser.*
import script.psi.elements.PsiFunction
import script.psi.elements.PsiInvoke
import script.psi.elements.PsiType
import script.psi.elements.PsiValue

object PsiFactory {

    fun createPsiElement(node: ASTNode): PsiElement {
        val nodeType = node.elementType
        if (nodeType is RuleIElementType)
            return convertRuleIndexToPsi(nodeType.ruleIndex, node)
        return ANTLRPsiNode(node)
    }

    private fun convertRuleIndexToPsi(index: Int, node: ASTNode) = when(index) {
        RULE_type -> PsiType(node)
        RULE_value -> PsiValue(node)
        RULE_invoke -> PsiInvoke(node)
        RULE_func_statement -> PsiFunction(node)
        else -> ANTLRPsiNode(node)
    }

}
