package gdscript.completion

import version.VersionService
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.components.service
import com.intellij.psi.util.PsiTreeUtil
import gdscript.completion.utils.LookupFactory

class TypeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val prevText = PsiTreeUtil.prevVisibleLeaf(parameters.position)?.text
        if (prevText in TYPE_TOKENS)
            result.caseInsensitive().addAllElements(collectLookups())
    }

    private fun collectLookups(): List<LookupElement> {
        val api = VersionService.current()
        val primitiveTypes = api.primitives.map { LookupFactory.createKeyword(it.name) }
        val classTypes = api.classes.map { LookupFactory.createClass(it) }
        return primitiveTypes + classTypes
    }

    private companion object {

        private val TYPE_TOKENS = listOf("as", "is", "->", ":", "extends")

    }

}
