package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.Colors
import gdscript.ScriptTokenType.IDENTIFIER
import gdscript.utils.PsiElementUtils.isLeaf

class ConstantAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isLeaf(IDENTIFIER) && element.text.matches(CONSTANT_REGEX)) {
            val info = holder.createInfoAnnotation(element, null)
            info.textAttributes = Colors.CONSTANT.key
        }
    }

    private companion object {

        val CONSTANT_REGEX = "[A-Z][A-Z0-9_]+".toRegex()

    }

}