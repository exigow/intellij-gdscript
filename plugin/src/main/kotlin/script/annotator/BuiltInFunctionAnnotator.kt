package script.annotator

import GodotApi
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import script.colors.ScriptColor

class BuiltInFunctionAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.text in LANGUAGE_METHODS)
            holder.createColorInformation(element, ScriptColor.BUILT_IN_FUNCTION)
    }

    companion object {

        private val LANGUAGE_METHODS = GodotApi.CLASSES
            .find { it.name == "@GDScript" }!!.methods
            .map { it.name }

    }

}