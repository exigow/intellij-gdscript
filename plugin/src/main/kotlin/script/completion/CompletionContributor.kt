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
        extend(BASIC, INSIDE_TYPE, provide(PRIMITIVES, LANGUAGE_LEVEL_VALUE_PRIORITY))
        extend(BASIC, INSIDE_TYPE, provide(CLASSES, CLASS_PRIORITY))
        extend(BASIC, INSIDE_INVOKE, provide(FUNCTION_CALLS, FUNCTION_PRIORITY))
        extend(BASIC, INSIDE_INVOKE, provide(CONSTRUCTOR_CALLS, CLASS_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(SELF, LANGUAGE_LEVEL_VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(TRUE, LANGUAGE_LEVEL_VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(FALSE, LANGUAGE_LEVEL_VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(FUNCTION_CALLS, FUNCTION_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(CONSTANTS, LANGUAGE_LEVEL_VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(CONSTRUCTOR_CALLS, CLASS_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(VAR, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(CONST, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(FUNC, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(FOR, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(WHILE, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(CLASS, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(EXTENDS, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(CLASS_NAME, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(ENUM, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(IF, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(ELIF, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(ELSE, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(RETURN, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(SIGNAL, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(EXPORT, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(STATIC, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_EXPORT_KEYWORD, provide(VAR, KEYWORD_PRIORITY))
        extend(BASIC, AFTER_STATIC_KEYWORD, provide(FUNC, KEYWORD_PRIORITY))
    }

    private fun provide(lookups: List<LookupElement>, priority: Int = 0) = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val prioritized = lookups.map { withPriority(it, priority.toDouble()) }
            result.addAllElements(prioritized)
        }

    }

    private companion object {

        const val KEYWORD_PRIORITY = 100
        const val LANGUAGE_LEVEL_VALUE_PRIORITY = 70
        const val FUNCTION_PRIORITY = 30
        const val CLASS_PRIORITY = 10

        private val INSIDE_TYPE = psiElement().inside(TypePsiElement::class.java)
        private val INSIDE_INVOKE = psiElement().inside(InvokePsiElement::class.java)
        private val INSIDE_VALUE = psiElement().inside(ValuePsiElement::class.java)
        private val AFTER_NEWLINE = psiElement().afterLeaf("\n")
        private val AFTER_EXPORT_KEYWORD = psiElement().afterLeaf("export")
        private val AFTER_STATIC_KEYWORD = psiElement().afterLeaf("static")

    }

}
