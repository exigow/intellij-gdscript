package gdscript.annotator

import ScriptLexer.IDENTIFIER
import ScriptParser.RULE_instance_field_expression
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.lang.psi.PsiElementUtils.rule
import gdscript.colorSettingsPage.ColorTextAttributeKey
import gdscript.lang.psi.PsiElementUtils.token

class InstanceFieldAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isIdentifier = element.token() == IDENTIFIER
        val isInsideInstanceField = element.parent.rule() == RULE_instance_field_expression
        if (isIdentifier && isInsideInstanceField)
            holder.colorize(element, ColorTextAttributeKey.INSTANCE_FIELD)
    }

}