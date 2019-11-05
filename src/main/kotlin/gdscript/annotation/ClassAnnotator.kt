package gdscript.annotation

import ScriptParser.RULE_type
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.utilities.PsiElementUtils.rule
import gdscript.options.ColorTextAttributeKey.CLASS_NAME

class ClassAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isType = element.rule() == RULE_type
        if (isType && hasClassName(element))
            holder.createColorAnnotation(element, CLASS_NAME)
    }

    private fun hasClassName(element: PsiElement): Boolean {
        val name = element.node.text
        return CompletionUtils.isClass(name)
    }


}