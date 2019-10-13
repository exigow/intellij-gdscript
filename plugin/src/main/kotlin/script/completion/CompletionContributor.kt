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
        extend(BASIC, INSIDE_TYPE, provide(PRIMITIVE_CLASS, VALUE_PRIORITY))
        extend(BASIC, INSIDE_TYPE, provide(OBJECT_CLASS, CLASS_PRIORITY))
        extend(BASIC, INSIDE_INVOKE, provide(FUNCTION_CALL, FUNCTION_PRIORITY))
        extend(BASIC, INSIDE_INVOKE, provide(CONSTRUCTOR_CALL, CLASS_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(SELF, VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(TRUE, VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(FALSE, VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(FUNCTION_CALL, FUNCTION_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(CONSTANT, VALUE_PRIORITY))
        extend(BASIC, INSIDE_VALUE, provide(CONSTRUCTOR_CALL, CLASS_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(VAR, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(CONST, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(FUNC, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(FOR, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(WHILE, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(CLASS, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(EXTENDS, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(CLASS_NAME, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(ENUM, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(IF, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(ELIF, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(ELSE, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(RETURN, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(SIGNAL, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(EXPORT, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_NEWLINE, provide(STATIC, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_EXPORT_KEYWORD, provide(VAR, STATEMENT_PRIORITY))
        extend(BASIC, AFTER_STATIC_KEYWORD, provide(FUNC, STATEMENT_PRIORITY))
    }

    private fun provide(lookups: List<LookupElement>, priority: Int = 0) = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val prioritized = lookups.map { withPriority(it, priority.toDouble()) }
            result.addAllElements(prioritized)
        }

    }

    private companion object {

        const val STATEMENT_PRIORITY = 100
        const val VALUE_PRIORITY = 70
        const val FUNCTION_PRIORITY = 50
        const val CLASS_PRIORITY = 10

        private val INSIDE_TYPE = psiElement().inside(TypePsiElement::class.java)
        private val INSIDE_INVOKE = psiElement().inside(InvokePsiElement::class.java)
        private val INSIDE_VALUE = psiElement().inside(ValuePsiElement::class.java)
        private val AFTER_NEWLINE = psiElement().afterLeaf("\n")
        private val AFTER_EXPORT_KEYWORD = psiElement().afterLeaf("export")
        private val AFTER_STATIC_KEYWORD = psiElement().afterLeaf("static")

    }

}
