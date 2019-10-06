package script.completion

import GodotApi
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext


class BuiltInFunctionCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement(), LiteralProvider)
    }

    private object LiteralProvider : CompletionProvider<CompletionParameters>() {

        private val LANGUAGE_CLASS = GodotApi.CLASSES
            .find { it.name == "@GDScript" }!!

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            for (method in LANGUAGE_CLASS.methods) {
                val arguments = method.arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" }
                val lookup = create(method.name).bold().withItemTextItalic(true).withTailText(arguments).withTypeText(method.type)
                result.addElement(lookup)
            }
        }

    }

}
