package script

import GodotApi
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity.INFORMATION
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement

class ScriptAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement && element !is PsiWhiteSpace) {
            when {
                element.prev()?.text == "func" -> holder.createColorized(element, FUNCTION_DECLARATION)
                element.prev()?.text == "var" -> holder.createColorized(element, LOCAL_VARIABLE)
                element.prev()?.text == "const" -> holder.createColorized(element, CONSTANT)
                element.text in LANGUAGE_METHODS -> holder.createColorized(element, FUNCTION_CALL)
                element.text in CLASS_NAMES -> holder.createColorized(element, CLASS_NAME)
                element.text.length > 2 && element.text.isUnderscoreCase() -> holder.createColorized(element, CONSTANT)
            }
        }
    }

    private fun PsiElement.prev(): PsiElement? = when (prevSibling) {
        is PsiWhiteSpace -> prevSibling.prevSibling
        else -> null
    }

    private fun AnnotationHolder.createColorized(element: LeafPsiElement, attributesKey: TextAttributesKey) =
        createAnnotation(INFORMATION, element.textRange, null).also { it.textAttributes = attributesKey }

    private fun String.isUnderscoreCase() = all { (it.isLetter() && it.isUpperCase()) || it == '_' }

    companion object {

        private val CLASS_NAMES = GodotApi.CLASSES.map { it.name }.filter { it !in listOf("bool", "int", "float") }
        private val LANGUAGE_METHODS = GodotApi.CLASSES.find { it.name == "@GDScript" }!!.methods.map { it.name }

    }

}