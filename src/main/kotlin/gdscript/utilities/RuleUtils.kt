package gdscript.utilities

import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType

object RuleUtils {

    fun PsiElement.rule(): Int {
        val rule = node?.elementType as? RuleIElementType
        return rule?.ruleIndex ?: 0
    }

}