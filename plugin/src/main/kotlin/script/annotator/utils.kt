package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import script.colors.ScriptColor

internal fun AnnotationHolder.createColorAnnotation(element: PsiElement, color: ScriptColor) =
    createInfoAnnotation(element, null).also { it.textAttributes = color.key }!!