package script

import GodotApi
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity.*
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement

class ScriptAnnotator : Annotator {

    override fun annotate(current: PsiElement, holder: AnnotationHolder) {
        if (current is LeafPsiElement && current !is PsiWhiteSpace) {
            if (current.previous()?.text == "const") {
                holder.colorize(current, CONSTANT)
                if (current.text.canBeUpperCased())
                    holder.warnWeak(current, "Constant should have an upper case name such as `${current.text.toUpperCase()}`")
            }
            if (current.previous()?.text == "func") {
                if (current.previous()?.previous()?.text == "static")
                    holder.colorize(current, STATIC_METHOD)
                else
                    holder.colorize(current, FUNCTION_DECLARATION)
            }
            if (current.previous()?.text == "var")
                holder.colorize(current, LOCAL_VARIABLE)
            if (current.text in LANGUAGE_METHODS)
                holder.colorize(current, FUNCTION_CALL)
            if (current.text in CLASS_NAMES)
                holder.colorize(current, CLASS_NAME)
            if (current.text.length > 2 && current.text.isUnderscoreCase())
                holder.colorize(current, CONSTANT)
        }
    }

    private fun String.canBeUpperCased() = this != this.toUpperCase()

    private tailrec fun PsiElement.previous(): PsiElement? =
        when (prevSibling) {
            is PsiWhiteSpace -> prevSibling.previous()
            else -> prevSibling
        }

    private fun AnnotationHolder.colorize(element: LeafPsiElement, attributesKey: TextAttributesKey) =
        createAnnotation(INFORMATION, element.textRange, null).also { it.textAttributes = attributesKey }

    private fun AnnotationHolder.warnWeak(element: LeafPsiElement, message: String) =
        createAnnotation(WEAK_WARNING, element.textRange, message)

    private fun String.isUnderscoreCase() = all { (it.isLetter() && it.isUpperCase()) || it == '_' }

    companion object {

        private val CLASS_NAMES = GodotApi.CLASSES.map { it.name }.filter { it !in listOf("bool", "int", "float") }
        private val LANGUAGE_METHODS = GodotApi.CLASSES.find { it.name == "@GDScript" }!!.methods.map { it.name }

    }

}