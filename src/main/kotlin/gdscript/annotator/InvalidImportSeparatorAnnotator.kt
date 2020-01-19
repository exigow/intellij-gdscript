package gdscript.annotator

import ScriptLexer.RESOURCE
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.lang.psi.PsiElementUtils.isToken

class InvalidImportSeparatorAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(RESOURCE) && element.text.contains("\\"))
            holder.createErrorAnnotation(element, "Invalid separator")
    }

}