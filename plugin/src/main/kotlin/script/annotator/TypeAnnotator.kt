package script.annotator

import GodotApi
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity.INFORMATION
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement
import script.colors.ScriptColor

class TypeAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && element !is PsiWhiteSpace)
            if (element.text in CLASS_TYPES)
                holder.colorize(element, ScriptColor.CLASS_TYPE.key)
    }

    private fun AnnotationHolder.colorize(element: LeafPsiElement, attributesKey: TextAttributesKey) =
        createAnnotation(INFORMATION, element.textRange, null)
            .also { it.textAttributes = attributesKey }

    companion object {

        private val CLASS_TYPES = GodotApi.CLASSES.map { it.name }

    }

}