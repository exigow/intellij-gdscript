package gdscript.annotation

import ScriptLexer.IDENTIFIER
import ScriptParser.RULE_instance_field_expression
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.utilities.PsiElementUtils.rule
import gdscript.options.ColorTextAttributeKey.INSTANCE_FIELD
import gdscript.utilities.PsiElementUtils.token

class InstanceFieldAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isIdentifier = element.token() == IDENTIFIER
        val isInsideInstanceField = element.parent.rule() == RULE_instance_field_expression
        if (isIdentifier && isInsideInstanceField)
            holder.createColorAnnotation(element, INSTANCE_FIELD)
    }

}