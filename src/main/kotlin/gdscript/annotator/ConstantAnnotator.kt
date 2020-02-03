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
        if (element.isToken(IDENTIFIER) && text.matches(CONSTANT_REGEX))
            holder.colorize(element, CONSTANT)
    }

    private companion object {

        val CONSTANT_REGEX = "[A-Z][A-Z0-9_]+".toRegex()

    }

}