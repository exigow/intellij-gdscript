package gdscript.completion

import ScriptParser.RULE_type
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory
import gdscript.lang.psi.PsiElementUtils.hasParent

class TypeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (parameters.position.hasParent(RULE_type))
            result.caseInsensitive().addAllElements(ALL_TYPE_LOOKUPS)
    }

    private companion object {

        private val ALL_TYPE_LOOKUPS = listOf(
            CompletionUtils.PRIMITIVES.map { LookupFactory.createKeyword(it.name) },
            CompletionUtils.CLASSES.map { LookupFactory.createClass(it) }
        ).flatten()

    }

}
