package gdscript.completion

import ScriptParser.RULE_invoke
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory
import gdscript.lang.psi.PsiElementUtils.rule


class InvokeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (isInsideInvoke(parameters.position))
            result.caseInsensitive().addAllElements(ALL_INVOKE_LOOKUPS)
    }

    private fun isInsideInvoke(element: PsiElement) =
        element.parent.rule() == RULE_invoke

    companion object {

        private val ALL_INVOKE_LOOKUPS = listOf(
            CompletionUtils.functions().map { LookupFactory.createFunction(it) },
            CompletionUtils.classConstructors().map { LookupFactory.createConstructor(it) },
            CompletionUtils.primitiveConstructors().map { LookupFactory.createPrimitiveConstructor(it) }
        ).flatten()

    }

}
