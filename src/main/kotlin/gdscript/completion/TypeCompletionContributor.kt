package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import common.PsiElementUtils.hasParent
import gdscript.ScriptParser.RULE_type
import gdscript.completion.sources.CompletionDictionary
import gdscript.completion.utils.LookupFactory

class TypeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (parameters.position.hasParent(RULE_type))
            result.caseInsensitive().addAllElements(ALL_TYPE_LOOKUPS)
    }

    private companion object {

        private val ALL_TYPE_LOOKUPS = listOf(
            CompletionDictionary.PRIMITIVES.map { LookupFactory.createKeyword(it.name) },
            CompletionDictionary.CLASSES.map { LookupFactory.createClass(it) }
        ).flatten()

    }

}
