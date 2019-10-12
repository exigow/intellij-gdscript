package script.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import script.colors.ScriptColor
import script.grammar.ScriptLexer

internal fun AnnotationHolder.createColorAnnotation(element: PsiElement, color: ScriptColor) =
    createInfoAnnotation(element, null).also { it.textAttributes = color.key }!!

internal fun PsiElement.isIdentifier() =
    isToken(ScriptLexer.IDENTIFIER)

internal fun PsiElement.isToken(expected: Int) =
    ((this as? LeafPsiElement)?.elementType as? TokenIElementType)?.antlrTokenType == expected