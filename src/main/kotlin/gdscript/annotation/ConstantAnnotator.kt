package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import common.PsiElementUtils.isToken
import gdscript.Colors.CONSTANT
import gdscript.ScriptLexer.IDENTIFIER

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