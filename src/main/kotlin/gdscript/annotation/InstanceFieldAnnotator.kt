package gdscript.annotation

import ScriptParser.RULE_instance_field_expression
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.utilities.RuleUtils.rule
import gdscript.options.ColorTextAttributeKey.INSTANCE_FIELD
import gdscript.utilities.PsiLeafUtils.isIdentifier

class InstanceFieldAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isInsideInstanceField = element.parent.rule() == RULE_instance_field_expression
        if (element.isIdentifier() && isInsideInstanceField)
            holder.createColorAnnotation(element, INSTANCE_FIELD)
    }

}