package gdscript.annotator

import ScriptParser.RULE_type
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.colorSettingsPage.ColorTextAttributeKey.CLASS_NAME
import gdscript.completion.sources.CompletionUtils
import gdscript.lang.psi.PsiElementUtils.isRule

class ClassAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isRule(RULE_type) && hasPrimitiveName(element))
            holder.colorize(element, CLASS_NAME)
    }

    private fun hasPrimitiveName(element: PsiElement): Boolean {
        val name = element.node.text
        return !CompletionUtils.isPrimitive(name)
    }

}