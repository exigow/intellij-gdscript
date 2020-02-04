package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import common.PsiElementUtils.hasParent
import gdscript.ScriptParser.RULE_primary
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory

class PrimaryCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (element.hasParent(RULE_primary) && hasNotDigitPrefix(element))
            result.addAllElements(ALL_PRIMARY_LOOKUPS)
    }

    private fun hasNotDigitPrefix(element: PsiElement) =
        !element.text.first().isDigit()

    private companion object {

        val ALL_PRIMARY_LOOKUPS = listOf(
            CompletionUtils.SINGLETONS.map { LookupFactory.createSingleton(it) },
            CompletionUtils.LANGUAGE_CONSTANTS.map { LookupFactory.createConstant(it) },
            CompletionUtils.FUNCTIONS.map { LookupFactory.createFunction(it) },
            CompletionUtils.CLASS_CONSTRUCTORS.map { LookupFactory.createConstructor(it) },
            CompletionUtils.PRIMITIVE_CONSTRUCTORS.map { LookupFactory.createPrimitiveConstructor(it) },
            CompletionUtils.VARIABLE_KEYWORDS.map { LookupFactory.createKeyword(it) }
        ).flatten()

    }

}
