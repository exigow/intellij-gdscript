package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import script.colors.ScriptColor.CLASS_TYPE
import script.psi.TypeNode

class TypeAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is TypeNode)
            holder.createColorAnnotation(element, CLASS_TYPE)
    }

}