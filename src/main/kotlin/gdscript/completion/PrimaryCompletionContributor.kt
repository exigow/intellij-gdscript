package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import common.PsiElementUtils.hasAncestors
import common.PsiElementUtils.isToken
import gdscript.ScriptLexer.NUMBER
import gdscript.ScriptParser.RULE_id
import gdscript.ScriptParser.RULE_primary
import gdscript.completion.sources.CompletionDictionary
import gdscript.completion.utils.LookupFactory

class PrimaryCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (element.hasAncestors(RULE_id, RULE_primary) && hasNotDigitPrefix(parameters))
            result.addAllElements(ALL_PRIMARY_LOOKUPS)
    }

    private fun hasNotDigitPrefix(parameters: CompletionParameters): Boolean {
        val elementBeforeOffset = parameters.position.containingFile.findElementAt(parameters.offset - 1)!!
        return !elementBeforeOffset.isToken(NUMBER)
    }

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
