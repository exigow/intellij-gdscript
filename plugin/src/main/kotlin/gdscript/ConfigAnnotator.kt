package gdscript

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.METADATA
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.grammar.ConfigLexer.STRING
import org.antlr.intellij.adaptor.lexer.TokenIElementType

class ConfigAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isLeafToken(STRING))
            if (element.text.removeSurrounding("\"").startsWith("res://"))
                holder.createAnnotationAttribute(element, METADATA)
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