package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.completion.sources.COMPLETION_DATA
import gdscript.options.ColorTextAttributeKey.KEYWORD
import gdscript.psi.InvokeRule

class KeywordAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.parent is InvokeRule && element.isIdentifier() && element.hasFunctionText())
            holder.createColorAnnotation(element, KEYWORD)
    }

    private fun PsiElement.hasFunctionText() =
        text in LANGUAGE_FUNCTION_NAMES

    companion object {

        private val LANGUAGE_FUNCTION_NAMES = COMPLETION_DATA.functions
            .map { it.name }

    }

}