package gdscript.completion

import classes.CompletionDictionary
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.util.PsiTreeUtil
import gdscript.completion.utils.LookupFactory

class TypeCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val prevText = PsiTreeUtil.prevVisibleLeaf(parameters.position)?.text
        if (prevText in TYPE_TOKENS)
            result.caseInsensitive().addAllElements(ALL_TYPE_LOOKUPS)
    }

    private companion object {

        private val TYPE_TOKENS = listOf("as", "is", "->", ":", "extends")

        private val ALL_TYPE_LOOKUPS = listOf(
            CompletionDictionary.PRIMITIVE_CLASSES.map { LookupFactory.createKeyword(it.name) },
            CompletionDictionary.ALL_CLASSES.map { LookupFactory.createClass(it) }
        ).flatten()

    }

}
