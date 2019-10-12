package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import script.ScriptColor.CLASS_NAME
import script.psi.elements.TypePsiElement

class ClassNameAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is TypePsiElement && element.isNotPrimitive()) {
            holder.createColorAnnotation(element, CLASS_NAME)
        }
    }

}