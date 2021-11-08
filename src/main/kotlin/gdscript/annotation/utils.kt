package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement

fun AnnotationHolder.createTextAttributesAnnotation(element: PsiElement, textAttributes: TextAttributesKey) {
    val annotation = createInfoAnnotation(element, null)
    annotation.textAttributes = textAttributes
}