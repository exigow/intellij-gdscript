package script.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext
import script.psi.ValueNode


class LiteralCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().inside(ValueNode::class.java), LiteralProvider)
    }

    private object LiteralProvider : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            for (keyword in listOf("self", "true", "false"))
                result.addElement(create(keyword).bold())
        }

    }

}
