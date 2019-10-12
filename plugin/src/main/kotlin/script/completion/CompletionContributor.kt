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
        extend(BASIC, INSIDE_TYPE, prioritized(PRIMITIVE_LOOKUPS, 1))
        extend(BASIC, INSIDE_TYPE, prioritized(CLASS_LOOKUPS, 0))
        extend(BASIC, INSIDE_INVOKE, prioritized(FUNCTION_CALL_LOOKUPS, 1))
        extend(BASIC, INSIDE_INVOKE, prioritized(CONSTRUCTOR_CALL_LOOKUPS, 0))
        extend(BASIC, INSIDE_VALUE, prioritized(SELF_TRUE_FALSE_LOOKUPS, 2))
        extend(BASIC, INSIDE_VALUE, prioritized(FUNCTION_CALL_LOOKUPS, 1))
        extend(BASIC, INSIDE_VALUE, prioritized(CONSTANT_LOOKUPS, 1))
        extend(BASIC, INSIDE_VALUE, prioritized(CONSTRUCTOR_CALL_LOOKUPS, 0))
        extend(BASIC, AFTER_EXPORT_LEAF, simple(VAR_LOOKUP))
        extend(BASIC, AFTER_STATIC_LEAF, simple(FUNC_LOOKUP))
    }

    private fun simple(lookup: LookupElement) = prioritized(listOf(lookup), 0)

    private fun prioritized(lookups: List<LookupElement>, priority: Int) = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val prioritized = lookups.map { withPriority(it, priority.toDouble()) }
            result.addAllElements(prioritized)
        }

    }

    private companion object {

        private val INSIDE_TYPE = psiElement().inside(TypePsiElement::class.java)
        private val INSIDE_INVOKE = psiElement().inside(InvokePsiElement::class.java)
        private val INSIDE_VALUE = psiElement().inside(ValuePsiElement::class.java)
        private val AFTER_EXPORT_LEAF = psiElement().afterLeaf("export")
        private val AFTER_STATIC_LEAF = psiElement().afterLeaf("static")

    }

}
