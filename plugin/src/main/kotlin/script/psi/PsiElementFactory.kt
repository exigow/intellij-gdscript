package script.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import script.grammar.ScriptParser.*
import script.psi.elements.FunctionPsiElement
import script.psi.elements.InvokePsiElement
import script.psi.elements.TypePsiElement
import script.psi.elements.ValuePsiElement

object PsiElementFactory {

    fun createPsiElement(node: ASTNode): PsiElement {
        val nodeType = node.elementType
        if (nodeType is RuleIElementType)
            return convertRuleIndexToPsi(nodeType.ruleIndex, node)
        return ANTLRPsiNode(node)
    }

    private fun convertRuleIndexToPsi(index: Int, node: ASTNode) = when(index) {
        RULE_type -> TypePsiElement(node)
        RULE_value -> ValuePsiElement(node)
        RULE_invoke -> InvokePsiElement(node)
        RULE_func_statement -> FunctionPsiElement(node)
        else -> ANTLRPsiNode(node)
    }

}
