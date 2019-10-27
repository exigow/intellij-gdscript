package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey

class UpperCaseConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isIdentifier() && isUpperCase(element.text))
            holder.createColorAnnotation(element, ColorTextAttributeKey.CONSTANT)
    }

    private fun isUpperCase(text: String) =
        text.length >= 2 && text.all { (it.isLetter() && it.isUpperCase()) || it == '_' }

}