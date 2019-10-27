package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey.INSTANCE_FIELD

class InstanceFieldAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isIdentifier() && element.isAfterDot())
            holder.createColorAnnotation(element, INSTANCE_FIELD)
    }

    private fun PsiElement.isAfterDot() =
        parent?.prevSibling?.text == "."

}