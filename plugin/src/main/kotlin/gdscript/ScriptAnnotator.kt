package gdscript

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.grammar.ScriptLexer.IDENTIFIER
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ScriptAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isLeafToken(IDENTIFIER))
            if (element.closestPreviousLeaf().text == "func")
                holder.createAnnotationAttribute(element, FUNCTION_DECLARATION)
    }

    private fun PsiElement.closestPreviousLeaf() = when (prevSibling) {
        null -> this
        is PsiWhiteSpace -> prevSibling.prevSibling
        else -> prevSibling
    }


    private fun PsiElement.isLeafToken(token: Int): Boolean {
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