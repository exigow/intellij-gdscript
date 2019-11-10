package gdscript.lang.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType

object PsiElementUtils {

    fun PsiElement.rule(): Int {
        val rule = node?.elementType as? RuleIElementType
        return rule?.ruleIndex ?: 0
    }

    fun PsiElement.token(): Int {
        val leaf = this as? LeafPsiElement
        val token = leaf?.elementType
        val typeToken = token as? TokenIElementType
        return typeToken?.antlrTokenType ?: 0
    }

}