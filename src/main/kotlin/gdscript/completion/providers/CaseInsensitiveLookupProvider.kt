package gdscript.completion.providers

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.util.ProcessingContext

class CaseInsensitiveLookupProvider(private val lookups: List<LookupElement>) : CompletionProvider<CompletionParameters>() {

    constructor(lookup: LookupElement) : this(listOf(lookup))

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.caseInsensitive().addAllElements(lookups)
    }

}