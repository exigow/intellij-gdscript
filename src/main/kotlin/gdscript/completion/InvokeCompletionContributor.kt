package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import common.PsiElementUtils.hasParent
import gdscript.ScriptParser.RULE_invoke
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory

class InvokeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (parameters.position.hasParent(RULE_invoke))
            result.caseInsensitive().addAllElements(ALL_INVOKE_LOOKUPS)
    }

    companion object {

        private val ALL_INVOKE_LOOKUPS = listOf(
            CompletionUtils.FUNCTIONS.map { LookupFactory.createFunction(it) },
            CompletionUtils.CLASS_CONSTRUCTORS.map { LookupFactory.createConstructor(it) },
            CompletionUtils.PRIMITIVE_CONSTRUCTORS.map { LookupFactory.createPrimitiveConstructor(it) }
        ).flatten()

    }

}
