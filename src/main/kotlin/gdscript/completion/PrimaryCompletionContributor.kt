package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import common.PsiElementUtils.hasParent
import gdscript.ScriptParser.RULE_primary
import gdscript.completion.sources.CompletionDictionary
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
            CompletionDictionary.SINGLETONS.map { LookupFactory.createSingleton(it) },
            CompletionDictionary.LANGUAGE_CONSTANTS.map { LookupFactory.createConstant(it) },
            CompletionDictionary.FUNCTIONS.map { LookupFactory.createFunction(it) },
            CompletionDictionary.CLASS_CONSTRUCTORS.map { LookupFactory.createConstructor(it) },
            CompletionDictionary.PRIMITIVE_CONSTRUCTORS.map { LookupFactory.createPrimitiveConstructor(it) },
            CompletionDictionary.VARIABLE_KEYWORDS.map { LookupFactory.createKeyword(it) }
        ).flatten()

    }

}
