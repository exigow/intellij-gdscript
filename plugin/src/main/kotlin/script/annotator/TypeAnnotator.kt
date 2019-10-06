package script.annotator

import GodotApi
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement
import script.colors.ScriptColor

class TypeAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && element !is PsiWhiteSpace && element.text in CLASS_TYPES)
            holder.createColorInformation(element, ScriptColor.CLASS_TYPE)
    }

    companion object {

        private val CLASS_TYPES = GodotApi.CLASSES.map { it.name }

    }

}