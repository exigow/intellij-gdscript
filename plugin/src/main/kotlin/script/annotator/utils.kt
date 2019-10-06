package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import script.colors.ScriptColor

internal fun AnnotationHolder.createColorInformation(element: PsiElement, color: ScriptColor) =
    createAnnotation(HighlightSeverity.INFORMATION, element.textRange, null)
        .also { it.textAttributes = color.key }!!