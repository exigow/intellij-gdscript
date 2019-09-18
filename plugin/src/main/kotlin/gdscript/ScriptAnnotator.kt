package gdscript

import Library
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.grammar.ScriptLexer.IDENTIFIER
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptAnnotator : Annotator {

    private val classNames = Library.load().classes.map { it.name }
    private val languageMethods = Library.load().classes.find { it.name == "@GDScript" }!!.methods.map { it.name }

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isLeaf(IDENTIFIER)) {
            if (element.afterLeaf("func"))
                holder.createAnnotationAttribute(element, FUNCTION_DECLARATION)
            if (element.afterLeaf("const"))
                holder.createAnnotationAttribute(element, CONSTANT)
            if (element.afterLeaf("class") || element.afterLeaf("extends") || element.afterLeaf("class_name") || classNames.any { it == element.text })
                holder.createAnnotationAttribute(element, INTERFACE_NAME)
            if (languageMethods.any { it == element.text })
                holder.createAnnotationAttribute(element, STATIC_METHOD)
        }
    }

    private fun PsiElement.afterLeaf(leaf: String) =
        closestPreviousLeaf().text == leaf

    private fun PsiElement.closestPreviousLeaf() = when (prevSibling) {
        null -> this
        is PsiWhiteSpace -> prevSibling.prevSibling
        else -> prevSibling
    }

    private fun PsiElement.isLeaf(token: Int): Boolean {
        if (this is LeafPsiElement) {
            val type = elementType
            if (type is TokenIElementType)
                return type.antlrTokenType == token
        }
        return false
    }

    private fun AnnotationHolder.createAnnotationAttribute(element: PsiElement, attribute: TextAttributesKey) =
        createAnnotation(HighlightSeverity.INFORMATION, element.textRange, null)
            .also { it.textAttributes = attribute }

}