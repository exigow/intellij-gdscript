package gdscript.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.completion.AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext
import gdscript.completion.sources.CompletionUtils


class KeywordCompletionContributor : CompletionContributor() {

    init {
        extendKeyword("\n", CompletionUtils.keywordsStatements())
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

    class KeywordCompletionProvider(private val texts: List<String>) : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val lookups = createLookups()
            result.addAllElements(lookups)
        }

        private fun createLookups() = texts.map {
            create(it)
                .withInsertHandler(INSTANCE_WITH_AUTO_POPUP)
                .bold()
                .withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
        }
    }

}
