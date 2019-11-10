package gdscript.annotator

import ScriptLexer.IDENTIFIER
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.colorSettingsPage.ColorTextAttributeKey
import gdscript.lang.psi.PsiElementUtils.token

class ConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val isIdentifier = element.token() == IDENTIFIER
        if (isIdentifier && isUpperCase(element.text))
            holder.createInfoAnnotation(element, null)
                .also { it.textAttributes = ColorTextAttributeKey.CONSTANT.key }
    }

    private fun isUpperCase(text: String) =
        text.length >= 2 && text.all { (it.isLetter() && it.isUpperCase()) || it == '_' }

}