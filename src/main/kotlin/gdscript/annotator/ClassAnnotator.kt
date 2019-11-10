package gdscript.annotator

import ScriptParser.RULE_type
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.colorSettingsPage.ColorTextAttributeKey
import gdscript.lang.psi.PsiElementUtils.rule

class ClassAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isType = element.rule() == RULE_type
        if (isType && hasClassName(element))
            holder.createInfoAnnotation(element, null)
                .also { it.textAttributes = ColorTextAttributeKey.CLASS_NAME.key }
    }

    private fun hasClassName(element: PsiElement): Boolean {
        val name = element.node.text
        return CompletionUtils.isClass(name)
    }


}