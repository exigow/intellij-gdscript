package script.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.VARIABLE_ICON
import com.intellij.util.ProcessingContext
import script.psi.elements.ValuePsiElement


class ValueCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().inside(ValuePsiElement::class.java), LiteralProvider)
    }

    private object LiteralProvider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            result.addElement(create("self").bold())
            result.addElement(create("true").bold())
            result.addElement(create("false").bold())
            result.addElement(create("PI").withItemTextItalic(true).withIcon(VARIABLE_ICON).bold())
            result.addElement(create("TAU").withItemTextItalic(true).withIcon(VARIABLE_ICON).bold())
        }

    }

}
