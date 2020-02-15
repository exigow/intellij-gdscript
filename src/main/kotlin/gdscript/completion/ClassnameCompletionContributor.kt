package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import common.PsiElementUtils.hasAncestors
import common.PsiElementUtils.isToken
import gdscript.ScriptParser.*
import gdscript.completion.utils.LookupFactory
import net.pearx.kasechange.toPascalCase

class ClassnameCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (element.hasAncestors(RULE_id, RULE_classnameLine) && element.isToken(IDENTIFIER)) {
            val lookup = createLookupFromFile(parameters)
            result.caseInsensitive().addElement(lookup)
        }
    }

    private fun createLookupFromFile(parameters: CompletionParameters): LookupElement {
        val filename = parameters
            .originalFile
            .virtualFile
            .nameWithoutExtension
            .toPascalCase()
        return LookupFactory.createClassname(filename)
    }

}
