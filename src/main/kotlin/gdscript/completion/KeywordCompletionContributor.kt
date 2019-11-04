package gdscript.completion

import com.intellij.codeInsight.completion.AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.CaseSensitiveLookupProvider


class KeywordCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, AFTER_NEWLINE, CaseSensitiveLookupProvider(STATEMENT_LOOKUPS))
        extend(BASIC, AFTER_EXPORT, CaseSensitiveLookupProvider(createKeywordSpaced("var")))
        extend(BASIC, AFTER_STATIC, CaseSensitiveLookupProvider(createKeywordSpaced("func")))
    }

    private companion object {

        val AFTER_NEWLINE =
            psiElement().afterLeaf("\n")

        val AFTER_EXPORT =
            psiElement().afterLeaf("export")

        val AFTER_STATIC =
            psiElement().afterLeaf("static")

        val STATEMENT_LOOKUPS =
            CompletionUtils.keywordsStatements()
                .map { createKeywordSpaced(it) }

        private fun createKeywordSpaced(name: String) =
            create(name)
                .withInsertHandler(INSTANCE_WITH_AUTO_POPUP)
                .bold()

    }

}
