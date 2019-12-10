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
        extend(CompletionType.BASIC, psiElement().afterLeaf("\n"), KeywordCompletionProvider(CompletionUtils.keywordsStatements()))
        extend(CompletionType.BASIC, psiElement().afterLeaf("export"), KeywordCompletionProvider(listOf("var")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("onready"), KeywordCompletionProvider(listOf("var")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("master"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("master"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("mastersync"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("puppet"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("puppetsync"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("remote"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("remotesync"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("sync"), KeywordCompletionProvider(listOf("var", "func")))
        extend(CompletionType.BASIC, psiElement().afterLeaf("static"), KeywordCompletionProvider(listOf("func")))
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
