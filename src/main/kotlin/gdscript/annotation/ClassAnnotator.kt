package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.CLASS_NAME
import gdscript.psi.TypeRule

class ClassAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is TypeRule && element.isNotPrimitive())
            holder.createColorAnnotation(element, CLASS_NAME)
    }

}