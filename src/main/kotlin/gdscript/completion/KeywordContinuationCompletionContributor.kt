package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.psi.util.PsiTreeUtil
import gdscript.completion.utils.LookupFactory


class KeywordContinuationCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        val previousLeafText = PsiTreeUtil.prevVisibleLeaf(element)?.text.orEmpty()
        val predicted = KEYWORD_CONTINUATIONS[previousLeafText]
        val lookups = predicted?.map { LookupFactory.createKeywordWithSpace(it) }.orEmpty()
        result.addAllElements(lookups)
    }

    private companion object {

        private val KEYWORD_CONTINUATIONS: Map<String, Set<String>> = mapOf(
            "export" to setOf("var"),
            "onready" to setOf("var"),
            "master" to setOf("var", "func"),
            "mastersync" to setOf("var", "func"),
            "puppet" to setOf("var", "func"),
            "puppetsync" to setOf("var", "func"),
            "remote" to setOf("var", "func"),
            "remotesync" to setOf("var", "func"),
            "sync" to setOf("var", "func"),
            "static" to setOf("func")
        )

    }

}