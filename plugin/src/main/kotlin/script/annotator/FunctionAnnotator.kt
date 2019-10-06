package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity.INFORMATION
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import script.colors.ScriptColor.FUNCTION_DECLARATION
import script.grammar.ScriptParser.IDENTIFIER
import script.grammar.ScriptParser.RULE_function_statement

class FunctionAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(IDENTIFIER)) {
            if (element.parent.parent.isRule(RULE_function_statement))
                holder.createAnnotation(INFORMATION, element.textRange, null)
                    .also { it.textAttributes = FUNCTION_DECLARATION.key }
        }
    }

    private fun PsiElement.isToken(expectedToken: Int): Boolean {
        if (this is LeafPsiElement) {
            val type = elementType
            if (type is TokenIElementType)
                return type.antlrTokenType == expectedToken

        }
        return false
    }

    private fun PsiElement.isRule(expectedRule: Int): Boolean {
        val nodeType = node.elementType
        if (nodeType is RuleIElementType)
            return nodeType.ruleIndex == expectedRule
        return false
    }

}