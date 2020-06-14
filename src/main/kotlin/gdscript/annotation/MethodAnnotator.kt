package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.Colors
import gdscript.ScriptTokenType
import gdscript.utils.PsiElementUtils.isLeaf

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isLeaf(ScriptTokenType.IDENTIFIER) && isAfterFuncKeyword(element)) {
            val info = holder.createInfoAnnotation(element, null)
            info.textAttributes = Colors.INSTANCE_METHOD.key
        }
    }

    private fun isAfterFuncKeyword(element: PsiElement) =
        PsiTreeUtil.prevVisibleLeaf(element)?.text == "func"

}