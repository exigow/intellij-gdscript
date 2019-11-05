package gdscript.annotation

import ScriptLexer.IDENTIFIER
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.CONSTANT
import gdscript.utilities.PsiElementUtils.token

class UpperCaseConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isIdentifier = element.token() == IDENTIFIER
        if (isIdentifier && isUpperCase(element.text))
            holder.createColorAnnotation(element, CONSTANT)
    }

    private fun isUpperCase(text: String) =
        text.length >= 2 && text.all { (it.isLetter() && it.isUpperCase()) || it == '_' }

}