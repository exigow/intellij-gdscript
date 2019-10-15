package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.GDScriptLexer.IDENTIFIER
import gdscript.options.ColorTextAttributeKey
import org.antlr.intellij.adaptor.lexer.TokenIElementType

internal fun AnnotationHolder.createColorAnnotation(element: PsiElement, color: ColorTextAttributeKey) =
    createInfoAnnotation(element, null).also { it.textAttributes = color.key }!!

internal fun PsiElement.isIdentifier() =
    isToken(IDENTIFIER)

internal fun PsiElement.isToken(expected: Int) =
    ((this as? LeafPsiElement)?.elementType as? TokenIElementType)?.antlrTokenType == expected