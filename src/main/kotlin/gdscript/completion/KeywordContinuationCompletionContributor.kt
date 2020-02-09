package gdscript.completion

import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext
import gdscript.completion.utils.LookupFactory


class KeywordContinuationCompletionContributor : CompletionContributor() {

    init {
        extendContinuation("export", listOf("var"))
        extendContinuation("onready", listOf("var"))
        extendContinuation("master", listOf("var", "func"))
        extendContinuation("master", listOf("var", "func"))
        extendContinuation("mastersync", listOf("var", "func"))
        extendContinuation("puppet", listOf("var", "func"))
        extendContinuation("puppetsync", listOf("var", "func"))
        extendContinuation("remote", listOf("var", "func"))
        extendContinuation("remotesync", listOf("var", "func"))
        extendContinuation("sync", listOf("var", "func"))
        extendContinuation("static", listOf("func"))
    }

    private fun extendContinuation(trigger: String, nextKeywords: List<String>) {
        val rule = psiElement().afterLeaf(trigger)
        val provider = KeywordCompletionProvider(nextKeywords)
        extend(CompletionType.BASIC, rule, provider)
    }

    private class KeywordCompletionProvider(private val texts: List<String>)
        : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val lookups = texts.map { LookupFactory.createKeywordWithSpace(it) }
            result.addAllElements(lookups)
        }

    }

}
