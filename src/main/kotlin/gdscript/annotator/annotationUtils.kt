package gdscript.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import gdscript.colorSettingsPage.ColorTextAttributeKey

fun AnnotationHolder.colorize(element: PsiElement, color: ColorTextAttributeKey) {
    createInfoAnnotation(element, null)
        .also { it.textAttributes = color.key }
}
