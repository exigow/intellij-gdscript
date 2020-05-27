package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.Colors.INSTANCE_METHOD
import gdscript.ScriptLexer.IDENTIFIER
import gdscript.utils.PsiElementUtils.isToken

class MethodAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(IDENTIFIER) && isAfterFuncKeyword(element))
            holder.colorize(element, INSTANCE_METHOD)
    }

    private fun isAfterFuncKeyword(element: PsiElement) =
        PsiTreeUtil.prevVisibleLeaf(element)?.text == "func"

}