package gdscript.completion

import ScriptParser.RULE_invoke
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory
import gdscript.lang.psi.PsiElementUtils.hasParent

class InvokeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (parameters.position.hasParent(RULE_invoke))
            result.caseInsensitive().addAllElements(ALL_INVOKE_LOOKUPS)
    }

    companion object {

        private val ALL_INVOKE_LOOKUPS = listOf(
            CompletionUtils.functions().map { LookupFactory.createFunction(it) },
            CompletionUtils.classConstructors().map { LookupFactory.createConstructor(it) },
            CompletionUtils.primitiveConstructors().map { LookupFactory.createPrimitiveConstructor(it) }
        ).flatten()

    }

}
