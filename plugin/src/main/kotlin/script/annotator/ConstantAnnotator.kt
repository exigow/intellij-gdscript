package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import script.ScriptColor.CONSTANT

class ConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && isConstantCase(element.text))
            holder.createColorAnnotation(element, CONSTANT)
    }

    private fun isConstantCase(text: String) = text.length >= 2 && text.all { it.isUpperCaseLetter() || it == '_' }

    private fun Char.isUpperCaseLetter() = isLetter() && isUpperCase()

}