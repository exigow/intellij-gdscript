package script.completion.provider

import GodotApi
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withPriority
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons
import com.intellij.util.ProcessingContext
import script.completion.Priority

object ConstantProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        for (constant in GodotApi.LANGUAGE_CLASS.constants)
            result.addElement(withPriority(create(constant.name).withItemTextItalic(true).withTailText(" = ${constant.value}").withIcon(PlatformIcons.VARIABLE_ICON).bold(), Priority.CONSTANT))
    }

}