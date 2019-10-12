package script.annotator

import GodotApi
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import script.colors.ScriptColor.FUNCTION_CALL
import script.psi.elements.InvokePsiElement

class FunctionCallAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isLanguageFunctionCall())
            holder.createColorAnnotation(element, FUNCTION_CALL)
    }

    private fun PsiElement.isLanguageFunctionCall() =
        parent is InvokePsiElement && isIdentifier() && text in LANGUAGE_METHOD_NAMES

    companion object {

        private val LANGUAGE_METHOD_NAMES = GodotApi.LANGUAGE_CLASS.methods.map { it.name }

    }

}