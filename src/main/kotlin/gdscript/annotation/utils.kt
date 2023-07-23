package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement

fun AnnotationHolder.createTextAttributesAnnotation(element: PsiElement, textAttributes: TextAttributesKey) {
    newAnnotation(HighlightSeverity.INFORMATION, "")
        .range(element)
        .textAttributes(textAttributes)
        .create()
}
