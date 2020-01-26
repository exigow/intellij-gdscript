package gdscript.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.ScriptLexer.IDENTIFIER
import gdscript.colorSettingsPage.ColorTextAttributeKey.CONSTANT
import gdscript.lang.psi.PsiElementUtils.isToken

class ConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val text = element.text
        if (element.isToken(IDENTIFIER) && isConstantCase(text) && isLong(text))
            holder.colorize(element, CONSTANT)
    }

    private fun isLong(text: String) =
        text.length >= 2

    private fun isConstantCase(text: String) =
        text.all { it.isLetter() && it.isUpperCase() || it == '_' }

}