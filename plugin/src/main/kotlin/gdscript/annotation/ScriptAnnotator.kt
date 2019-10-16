package gdscript.annotation

import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.lang.psi.FunctionRule
import gdscript.lang.psi.InvokeRule
import gdscript.lang.psi.TypeRule
import gdscript.options.ColorTextAttributeKey.*

class ScriptAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        annotateMethod(element, holder)
        annotateClass(element, holder)
        annotateConstant(element, holder)
        annotateFunctionCall(element, holder)
    }

    private fun annotateMethod(element: PsiElement, holder: AnnotationHolder) {
        val parent = element.parent
        if (element.isIdentifier() && parent is FunctionRule)
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
        if (element.parent is InvokeRule && element.isIdentifier() && element.text in LANGUAGE_FUNCTION_NAMES)
            holder.createColorAnnotation(element, KEYWORD_FUNCTION_CALL)
    }

    private fun annotateClass(element: PsiElement, holder: AnnotationHolder) {
        if (element is TypeRule && element.isNotPrimitive())
            holder.createColorAnnotation(element, CLASS_NAME)
    }

    private fun isConstantCase(text: String) = text.length >= 2 && text.all { (it.isLetter() && it.isUpperCase()) || it == '_' }

    companion object {

        private val LANGUAGE_FUNCTION_NAMES = GLOBAL_SCOPE_CLASSES
            .flatMap { it.methods }
            .map { it.name }

    }

}