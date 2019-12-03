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
        val text = element.text
        if (isIdentifier && isConstantCase(text) && isLongEnough(text))
            holder.colorize(element, ColorTextAttributeKey.CONSTANT)
    }

    private fun isConstantCase(text: String) =
        text.all { it.isUpperCaseLetter() || it == '_' }

    private fun Char.isUpperCaseLetter() =
        isLetter() && isUpperCase()

    private fun isLongEnough(text: String) =
        text.length >= 2

}