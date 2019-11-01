package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.utilities.PsiLeafUtils.isAfterText
import gdscript.utilities.PsiLeafUtils.isIdentifier
import gdscript.options.ColorTextAttributeKey.INSTANCE_FIELD

class InstanceFieldAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isIdentifier() && element.isAfterText("."))
            holder.createColorAnnotation(element, INSTANCE_FIELD)
    }

}