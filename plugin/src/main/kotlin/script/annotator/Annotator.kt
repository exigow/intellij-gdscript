package script.annotator

import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import script.ScriptColor.*
import script.psi.elements.PsiFunction
import script.psi.elements.PsiInvoke
import script.psi.elements.PsiType

class Annotator : com.intellij.lang.annotation.Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateMethod(element, holder)
        annotateClass(element, holder)
        annotateConstant(element, holder)
        annotateFunctionCall(element, holder)
    }

    private fun annotateMethod(element: PsiElement, holder: AnnotationHolder) {
        val parent = element.parent
        if (element.isIdentifier() && parent is PsiFunction)
            if (parent.isStatic())
                holder.createColorAnnotation(element, STATIC_METHOD)
            else
                holder.createColorAnnotation(element, INSTANCE_METHOD)
    }

    private fun annotateConstant(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && isConstantCase(element.text))
            holder.createColorAnnotation(element, CONSTANT)
    }
    private fun annotateFunctionCall(element: PsiElement, holder: AnnotationHolder) {
        if (element.parent is PsiInvoke && element.isIdentifier() && element.text in LANGUAGE_METHOD_NAMES)
            holder.createColorAnnotation(element, FUNCTION_CALL)
    }

    private fun annotateClass(element: PsiElement, holder: AnnotationHolder) {
        if (element is PsiType && element.isNotPrimitive())
            holder.createColorAnnotation(element, CLASS_NAME)
    }

    private fun isConstantCase(text: String) = text.length >= 2 && text.all { (it.isLetter() && it.isUpperCase()) || it == '_' }

    companion object {

        private val LANGUAGE_METHOD_NAMES = GLOBAL_SCOPE_CLASSES
            .flatMap { it.methods }
            .map { it.name }

    }

}