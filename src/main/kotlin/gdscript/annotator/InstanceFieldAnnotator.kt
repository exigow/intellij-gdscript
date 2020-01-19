package gdscript.annotator

import ScriptLexer.IDENTIFIER
import ScriptParser.RULE_instance_field_expression
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.colorSettingsPage.ColorTextAttributeKey.INSTANCE_FIELD
import gdscript.lang.psi.PsiElementUtils.hasParent
import gdscript.lang.psi.PsiElementUtils.isToken

class InstanceFieldAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(IDENTIFIER) && element.hasParent(RULE_instance_field_expression))
            holder.colorize(element, INSTANCE_FIELD)
    }

}