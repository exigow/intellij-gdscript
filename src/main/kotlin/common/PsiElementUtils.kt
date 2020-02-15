package common

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

object PsiElementUtils {

    fun PsiElement.isToken(expected: Int): Boolean {
        val leaf = this as? LeafPsiElement
        val token = leaf?.elementType
        val typeToken = token as? TokenIElementType
        return typeToken?.antlrTokenType ?: 0 == expected
    }

    fun PsiElement.hasAncestors(expectedParent: Int, expectedGrandparent: Int) =
        parent.isRule(expectedParent) && parent.parent.isRule(expectedGrandparent)

    private fun PsiElement.isRule(expected: Int): Boolean {
        val rule = node?.elementType as? RuleIElementType
        return rule?.ruleIndex ?: 0 == expected
    }

}