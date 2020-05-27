package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import gdscript.ScriptParser.RULE_id
import gdscript.ScriptParser.RULE_invoke
import gdscript.completion.sources.CompletionDictionary
import gdscript.completion.utils.LookupFactory
import gdscript.utils.PsiElementUtils.hasAncestors

class InvokeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (parameters.position.hasAncestors(RULE_id, RULE_invoke))
            result.caseInsensitive().addAllElements(ALL_INVOKE_LOOKUPS)
    }

    companion object {

        private val ALL_INVOKE_LOOKUPS = listOf(
            CompletionDictionary.FUNCTIONS.map { LookupFactory.createFunction(it) },
            CompletionDictionary.CLASS_CONSTRUCTORS.map { LookupFactory.createConstructor(it) },
            CompletionDictionary.PRIMITIVE_CONSTRUCTORS.map { LookupFactory.createPrimitiveConstructor(it) }
        ).flatten()

    }

}
