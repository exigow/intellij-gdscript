package gdscript.completion

import ScriptParser.RULE_type
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory
import gdscript.lang.psi.PsiElementUtils.rule

class TypeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (isInsideType(parameters.position))
            result.caseInsensitive().addAllElements(ALL_TYPE_LOOKUPS)
    }

    private fun isInsideType(element: PsiElement) =
        element.parent.rule() == RULE_type

    private companion object {

        private val ALL_TYPE_LOOKUPS = listOf(
            CompletionUtils.primitives().map { LookupFactory.createKeyword(it.name) },
            CompletionUtils.classes().map { LookupFactory.createClass(it) }
        ).flatten()

    }

}
