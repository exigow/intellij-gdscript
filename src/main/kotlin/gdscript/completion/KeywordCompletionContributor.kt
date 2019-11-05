package gdscript.completion

import com.intellij.codeInsight.completion.AddSpaceInsertHandler.INSTANCE_WITH_AUTO_POPUP
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.psi.util.PsiTreeUtil
import gdscript.completion.sources.CompletionUtils


class KeywordCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val prevLeaf = PsiTreeUtil.prevLeaf(parameters.position)
        when (prevLeaf?.text) {
            "\n" -> result.addAllElements(STATEMENT_LOOKUPS)
            "export" -> result.addElement(VAR_LOOKUP)
            "static" -> result.addElement(FUNC_LOOKUP)
        }
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
