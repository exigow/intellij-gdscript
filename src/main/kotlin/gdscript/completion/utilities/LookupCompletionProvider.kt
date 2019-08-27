package gdscript.completion.utilities

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext


class LookupCompletionProvider(private val lookups: List<LookupElementBuilder>) : CompletionProvider<CompletionParameters>() {

    constructor(lookup: LookupElementBuilder) : this(listOf(lookup))

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addAllElements(lookups)
    }

}