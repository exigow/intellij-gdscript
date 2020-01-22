package gdscript.completion

import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.LookupFactory


class KeywordCompletionContributor : CompletionContributor() {

    init {
        extendKeyword("\n", CompletionUtils.STATEMENT_KEYWORDS)
        extendKeyword("export", listOf("var"))
        extendKeyword("onready", listOf("var"))
        extendKeyword("master", listOf("var", "func"))
        extendKeyword("master", listOf("var", "func"))
        extendKeyword("mastersync", listOf("var", "func"))
        extendKeyword("puppet", listOf("var", "func"))
        extendKeyword("puppetsync", listOf("var", "func"))
        extendKeyword("remote", listOf("var", "func"))
        extendKeyword("remotesync", listOf("var", "func"))
        extendKeyword("sync", listOf("var", "func"))
        extendKeyword("static", listOf("func"))
    }

    private fun extendKeyword(trigger: String, nextKeywords: List<String>) {
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
