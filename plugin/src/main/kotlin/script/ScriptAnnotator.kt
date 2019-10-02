package script

import Library
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity.INFORMATION
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class ScriptAnnotator : Annotator {

    private val classNames = Library.load().classes.map { it.name }.filter { it !in listOf("bool", "int", "float") }
    private val languageMethods = Library.load().classes.find { it.name == "@GDScript" }!!.methods.map { it.name }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is LeafPsiElement) {
            when {
                element.prevSibling?.text == "func" -> holder.createColorized(element, FUNCTION_DECLARATION)
                element.prevSibling?.text == "var" -> holder.createColorized(element, LOCAL_VARIABLE)
                element.prevSibling?.text == "const" -> holder.createColorized(element, CONSTANT)
                element.text in languageMethods -> holder.createColorized(element, FUNCTION_CALL)
                element.text in classNames -> holder.createColorized(element, CLASS_NAME)
                element.text.length > 3 && element.text.isUpperCase() -> holder.createColorized(element, CONSTANT)
            }
        }
    }

    private fun AnnotationHolder.createColorized(element: LeafPsiElement, attributesKey: TextAttributesKey) =
        createAnnotation(INFORMATION, element.textRange, null).also { it.textAttributes = attributesKey }

    private fun String.isUpperCase() = this == this.toUpperCase()

}