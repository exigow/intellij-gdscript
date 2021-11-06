package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import gdscript.Colors
import gdscript.psi.ScriptElementTypes.FUNC
import gdscript.psi.ScriptElementTypes.IDENTIFIER

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.elementType == IDENTIFIER && isAfterFunc(element))
            holder.createTextAttributesAnnotation(element, Colors.INSTANCE_METHOD.key)
    }

    private fun isAfterFunc(element: PsiElement) =
        PsiTreeUtil.prevVisibleLeaf(element)?.elementType == FUNC

}