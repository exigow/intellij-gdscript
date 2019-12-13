package gdscript.completion

import ScriptParser.RULE_primary
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory
import gdscript.lang.psi.PsiElementUtils.rule

class PrimaryCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (isInsidePrimary(element) && hasNotDigitPrefix(element))
            result.addAllElements(ALL_PRIMARY_LOOKUPS)
    }

    private fun isInsidePrimary(element: PsiElement) =
        element.parent.rule() == RULE_primary

    private fun hasNotDigitPrefix(element: PsiElement) =
        !element.text.first().isDigit()

    private companion object {

        val ALL_PRIMARY_LOOKUPS = listOf(
            CompletionUtils.singletons().map { LookupFactory.createSingleton(it) },
            CompletionUtils.constants().map { LookupFactory.createConstant(it) },
            CompletionUtils.functions().map { LookupFactory.createFunction(it) },
            CompletionUtils.classConstructors().map { LookupFactory.createConstructor(it) },
            CompletionUtils.primitiveConstructors().map { LookupFactory.createPrimitiveConstructor(it) },
            CompletionUtils.keywordVariables().map { LookupFactory.createKeyword(it) }
        ).flatten()

    }

}
