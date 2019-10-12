package script.completion

import GodotApi
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withPriority
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.VARIABLE_ICON
import com.intellij.util.ProcessingContext
import script.psi.elements.ValuePsiElement


class ConstantCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().inside(ValuePsiElement::class.java), ConstantProvider)
    }

    private object ConstantProvider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            for (constant in GodotApi.LANGUAGE_CLASS.constants)
                result.addElement(withPriority(create(constant.name).withItemTextItalic(true).withTailText(" = ${constant.value}").withIcon(VARIABLE_ICON).bold(), CompletionPriority.CONSTANT))
        }

    }

}
