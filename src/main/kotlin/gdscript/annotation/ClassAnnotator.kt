package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.options.ColorTextAttributeKey.CLASS_NAME
import gdscript.psi.TypeRule

class ClassAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is TypeRule && hasClassName(element))
            holder.createColorAnnotation(element, CLASS_NAME)
    }

    private fun hasClassName(element: PsiElement): Boolean {
        val name = element.node.text
        return CompletionUtils.isClass(name)
    }


}