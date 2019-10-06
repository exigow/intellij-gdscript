package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity.INFORMATION
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import script.colors.ScriptColor

class ConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && isConstantCase(element.text))
            holder.createAnnotation(INFORMATION, element.textRange, "Constant")
                .also { it.textAttributes = ScriptColor.CONSTANT.key }
    }

    private fun isConstantCase(text: String) = text.length >= 2 && text.all { it.isUnderscoreCase() }

    private fun Char.isUnderscoreCase() = this.isUpperCaseLetter() || this == '_'

    private fun Char.isUpperCaseLetter() = this.isLetter() && this.isUpperCase()

}