package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import gdscript.options.ColorTextAttributeKey

fun AnnotationHolder.createColorAnnotation(element: PsiElement, color: ColorTextAttributeKey) =
    createInfoAnnotation(element, null)
        .also { it.textAttributes = color.key }!!
