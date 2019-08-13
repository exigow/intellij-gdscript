package plugin

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.PlatformIcons
import com.intellij.util.ProcessingContext


class GDScriptCompletionContributor : CompletionContributor() {

    init {
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider(LookupElementBuilder.create("var").withIcon(PlatformIcons.METHOD_ICON)))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider(LookupElementBuilder.create("const")))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider(LookupElementBuilder.create("if")))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider(LookupElementBuilder.create("while")))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider(LookupElementBuilder.create("return")))
        extend(CompletionType.BASIC, placeEverywhere(), createCompletionProvider(LookupElementBuilder.create("extend")))
    }

    private fun placeEverywhere(): PsiElementPattern.Capture<PsiElement> {
        return PlatformPatterns.psiElement()
    }

    private fun createCompletionProvider(lookup: LookupElementBuilder) = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            result.addElement(lookup)
        }

    }

}
