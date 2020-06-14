package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.ScriptTokenType.DOT
import gdscript.ScriptTokenType.NUMBER
import gdscript.completion.sources.CompletionDictionary
import gdscript.completion.utils.LookupFactory
import gdscript.utils.PsiElementUtils.isLeaf
import gdscript.utils.PsiElementUtils.isStringLeaf

class PrimaryCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (isNotAfterDot(element) && !element.isStringLeaf() && hasNotDigitPrefix(parameters))
            result.addAllElements(ALL_PRIMARY_LOOKUPS)
    }

    private fun isNotAfterDot(element: PsiElement): Boolean {
        val prev = PsiTreeUtil.prevVisibleLeaf(element)
            ?: return true
        return !prev.isLeaf(DOT)
    }

    private fun hasNotDigitPrefix(parameters: CompletionParameters): Boolean {
        val elementBeforeOffset = parameters.position.containingFile.findElementAt(parameters.offset - 1)!!
        return !elementBeforeOffset.isLeaf(NUMBER)
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
