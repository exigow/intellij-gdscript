package plugin

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext


class GDScriptCompletionContributor : CompletionContributor() {

    init {
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider("var"))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider("const"))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider("if"))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider("while"))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider("return"))
    }

    private fun placeEverywhere(): PsiElementPattern.Capture<PsiElement> {
        return PlatformPatterns.psiElement().withLanguage(GDScript)
    }

    private fun createCompletionProvider(name: String) = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val lookup = LookupElementBuilder.create(name)
            result.addElement(lookup)
        }

    }

}
