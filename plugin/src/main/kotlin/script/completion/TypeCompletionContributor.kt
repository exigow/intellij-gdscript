package script.completion

import GodotApi
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.CLASS_ICON
import com.intellij.util.ProcessingContext
import script.psi.TypeNode


class TypeCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().inside(TypeNode::class.java), TypeProvider)
    }

    private object TypeProvider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val names = GodotApi.CLASSES.map { it.name }
            for (name in names)
                if (isPrimitive(name))
                    result.addElement(create(name).bold().withCaseSensitivity(false))
                else
                    result.addElement(create(name).withIcon(CLASS_ICON).withCaseSensitivity(false))

        }

        private fun isPrimitive(name: String) = name in listOf("float", "int", "bool")

    }

}
