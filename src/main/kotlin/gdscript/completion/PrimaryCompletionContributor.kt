package gdscript.completion

import classes.CompletionDictionary
import classes.GDScriptGrammar
import classes.model.Class
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.ScriptTokenType.DOT
import gdscript.ScriptTokenType.NUMBER
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
            CompletionDictionary.GLOBAL_CONSTANTS.map { LookupFactory.createConstant(it) },
            CompletionDictionary.GLOBAL_METHODS.map { LookupFactory.createFunction(it) },
            CompletionDictionary.SINGLETON_CLASSES.map { LookupFactory.createSingleton(it) },
            CompletionDictionary.INSTANCED_CLASSES.constructorMethods().map { LookupFactory.createConstructor(it) },
            CompletionDictionary.PRIMITIVE_CLASSES.constructorMethods().map { LookupFactory.createPrimitiveConstructor(it) },
            GDScriptGrammar.VARIABLE_KEYWORDS.map { LookupFactory.createKeyword(it) }
        ).flatten()


        private fun List<Class>.constructorMethods() =
            flatMap { c -> c.methods?.filter { it -> c.name == it.name }.orEmpty() }

    }

}
