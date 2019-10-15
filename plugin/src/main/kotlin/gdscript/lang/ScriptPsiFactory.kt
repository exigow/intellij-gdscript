package gdscript.lang

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import gdscript.GDScriptParser.*
import gdscript.lang.psi.PsiFunction
import gdscript.lang.psi.PsiInvoke
import gdscript.lang.psi.PsiType
import gdscript.lang.psi.PsiValue
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

object ScriptPsiFactory {

    fun createPsiElement(node: ASTNode): PsiElement {
        val nodeType = node.elementType
        if (nodeType is RuleIElementType)
            return convertRuleIndexToPsi(nodeType.ruleIndex, node)
        return ANTLRPsiNode(node)
    }

    private fun convertRuleIndexToPsi(index: Int, node: ASTNode) =
        when(index) {
            RULE_type -> PsiType(node)
            RULE_value -> PsiValue(node)
            RULE_invoke -> PsiInvoke(node)
            RULE_func_statement -> PsiFunction(node)
            else -> ANTLRPsiNode(node)
        }

}
