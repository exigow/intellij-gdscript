package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import common.Colors

fun AnnotationHolder.colorize(element: PsiElement, color: Colors) {
    createInfoAnnotation(element, null)
        .also { it.textAttributes = color.key }
}
