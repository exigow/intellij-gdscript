package script.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withPriority
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext
import script.psi.elements.InvokePsiElement
import script.psi.elements.TypePsiElement
import script.psi.elements.ValuePsiElement


class CompletionContributor : com.intellij.codeInsight.completion.CompletionContributor() {

    init {
        extend(BASIC, INSIDE_TYPE, providePrioritized(PRIMITIVE_LOOKUPS, 1.0))
        extend(BASIC, INSIDE_TYPE, providePrioritized(CLASS_LOOKUPS, 0.0))
        extend(BASIC, INSIDE_INVOKE, providePrioritized(FUNCTION_CALL_LOOKUPS, 1.0))
        extend(BASIC, INSIDE_INVOKE, providePrioritized(CONSTRUCTOR_CALL_LOOKUPS, 0.0))
        extend(BASIC, INSIDE_VALUE, providePrioritized(SELF_TRUE_FALSE_LOOKUPS, 4.0))
        extend(BASIC, INSIDE_VALUE, providePrioritized(CONSTANT_LOOKUPS, 3.0))
        extend(BASIC, INSIDE_VALUE, providePrioritized(FUNCTION_CALL_LOOKUPS, 2.0))
        extend(BASIC, INSIDE_VALUE, providePrioritized(CONSTRUCTOR_CALL_LOOKUPS, 1.0))
    }

    private fun providePrioritized(lookups: List<LookupElement>, priority: Double) = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val prioritized = lookups.map { withPriority(it, priority) }
            result.addAllElements(prioritized)
        }

    }

    private companion object {

        private val INSIDE_TYPE = psiElement().inside(TypePsiElement::class.java)
        private val INSIDE_INVOKE = psiElement().inside(InvokePsiElement::class.java)
        private val INSIDE_VALUE = psiElement().inside(ValuePsiElement::class.java)

    }

}
