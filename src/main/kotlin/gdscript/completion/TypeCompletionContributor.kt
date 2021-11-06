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
import version.VersionService

class TypeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (isInsideType(element) || isAfterTypeOperator(element))
            result.caseInsensitive().addAllElements(collectLookups())
    }

    private fun isInsideType(element: PsiElement) =
        element.parent.parent.elementType == TYPE

    private fun isAfterTypeOperator(element: PsiElement) =
        PsiTreeUtil.prevVisibleLeaf(element).elementType in listOf(IS, AS)

    private fun collectLookups(): List<LookupElement> {
        val api = VersionService.current()
        val primitiveTypes = api.primitives.map { LookupFactory.createKeyword(it.name) }
        val classTypes = api.classes.map { LookupFactory.createClass(it) }
        return primitiveTypes + classTypes
    }

}
