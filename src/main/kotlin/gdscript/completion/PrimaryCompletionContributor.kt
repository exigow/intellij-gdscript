package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import gdscript.completion.utils.LookupFactory
import gdscript.psi.ScriptElementTypes.*
import gdscript.psi.ScriptExpression
import version.VersionService
import version.data.Class

class PrimaryCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (isIdentifier(element) && isInsideExpression(element) && isNotAfterDot(element) && isNotAfterNumber(element))
            result.addAllElements(collectLookups())
    }

    private fun isIdentifier(element: PsiElement) =
        element.elementType == IDENTIFIER

    private fun isInsideExpression(element: PsiElement): Boolean {
        val closestExpression = PsiTreeUtil.getParentOfType(element, ScriptExpression::class.java)
            ?: return false
        return PsiTreeUtil.getDepth(element, closestExpression) <= 3
    }

    private fun isNotAfterDot(element: PsiElement) =
        PsiTreeUtil.prevVisibleLeaf(element).elementType != DOT

    private fun isNotAfterNumber(element: PsiElement) =
        PsiTreeUtil.prevVisibleLeaf(element).elementType !in listOf(REAL_NUMBER, BINARY_NUMBER, HEXADECIMAL_NUMBER)

    private fun collectLookups(): List<LookupElement> {
        val api = VersionService.current()
        val constants = api.globals.flatMap { it.constants }.map { LookupFactory.createConstant(it) }
        val functions = api.globals.flatMap { it.methods }.map { LookupFactory.createFunction(it) }
        val singletons = api.singletons.map { LookupFactory.createSingleton(it) }
        val constructors = filterConstructors(api.classes).map { LookupFactory.createConstructor(it) }
        val primitiveConstructors = filterConstructors(api.primitives).map { LookupFactory.createPrimitiveConstructor(it) }
        val keywords = listOf("true", "false", "null", "self").map { LookupFactory.createKeyword(it) }
        return constants + functions + singletons + constructors + primitiveConstructors + keywords
    }

    private fun filterConstructors(e: List<Class>) =
        e.flatMap { c -> c.methods.filter { c.name == it.name } }

}
