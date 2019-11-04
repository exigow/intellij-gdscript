package gdscript.completion

import com.intellij.codeInsight.completion.AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import gdscript.completion.sources.CompletionUtils
import gdscript.completion.utils.CaseSensitiveLookupProvider
import gdscript.completion.utils.CommonPatterns.AFTER_EXPORT
import gdscript.completion.utils.CommonPatterns.AFTER_NEWLINE
import gdscript.completion.utils.CommonPatterns.AFTER_STATIC


class KeywordCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, AFTER_NEWLINE, CaseSensitiveLookupProvider(STATEMENT_LOOKUPS))
        extend(BASIC, AFTER_EXPORT, CaseSensitiveLookupProvider(VAR_LOOKUP))
        extend(BASIC, AFTER_STATIC, CaseSensitiveLookupProvider(FUNC_LOOKUP))
    }

    private companion object {

        private val VAR_LOOKUP = createKeywordSpaced("var")

        private val FUNC_LOOKUP = createKeywordSpaced("func")

        private val STATEMENT_LOOKUPS =
            CompletionUtils.keywordsStatements()
                .map { createKeywordSpaced(it) }

        private fun createKeywordSpaced(name: String) =
            create(name)
                .withInsertHandler(INSTANCE_WITH_AUTO_POPUP)
                .bold()

    }

}
