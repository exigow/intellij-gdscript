package gdscript.completion.utilities

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.util.ProcessingContext


class PrioritizedLookupCompletionProvider(private val lookups: List<LookupElement>, private val priority: Priority = Priority.DEFAULT) : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        val prioritized = lookups.map { PrioritizedLookupElement.withPriority(it, priority.number) }
        result.addAllElements(prioritized)
    }

}