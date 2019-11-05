package gdscript.annotation

import ScriptParser.RULE_func_line
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.INSTANCE_METHOD
import gdscript.utilities.PsiLeafUtils.isIdentifier
import gdscript.utilities.RuleUtils.rule
class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isInsideFunc = element.parent.rule() == RULE_func_line
        if (element.isIdentifier() && isInsideFunc)
            holder.createColorAnnotation(element, INSTANCE_METHOD)
    }

}