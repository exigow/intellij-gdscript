package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.CONSTANT

class UpperCaseConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isIdentifier() && element.isUpperCase())
            holder.createColorAnnotation(element, CONSTANT)
    }

    private fun PsiElement.isUpperCase() =
        text.length >= 2 && text.all { (it.isLetter() && it.isUpperCase()) || it == '_' }

}