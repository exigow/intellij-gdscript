package plugin

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.PlatformIcons
import com.intellij.util.ProcessingContext
import plugin.deserialization.DocumentDeserializer
import plugin.deserialization.models.Document
import javax.swing.Icon


class GDScriptCompletionContributor : CompletionContributor() {

    init {
        extendEverywhere("var")
        extendEverywhere("const")
        extendEverywhere("if")
        extendEverywhere("while")
        extendEverywhere("return")
        extendEverywhere("extend")
        extendEverywhereCompletionWithDocumentMethods("/docs/GDScript.xml")
    }

    private fun extendEverywhere(word: String, icon: Icon? = null) {
        val lookup = LookupElementBuilder.create(word).withIcon(icon)
        val completionProvider = createCompletionProvider(lookup)
        extend(BASIC, PlatformPatterns.psiElement(), completionProvider)
    }

    private fun extendEverywhereCompletionWithDocumentMethods(documentName: String) {
        val words = deserializeDocument(documentName).methods!!
            .map { it.name }
            .filter { it.isNotEmpty() }
        for (word in words)
            extendEverywhere(word, PlatformIcons.METHOD_ICON)
    }

    private fun deserializeDocument(resourceName: String): Document {
        val deserializer = DocumentDeserializer()
        return deserializer.deserializeText(GDScriptCompletionContributor::class.java.getResource(resourceName).readText())
    }

    private fun createCompletionProvider(lookup: LookupElementBuilder) = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            result.addElement(lookup)
        }

    }

}
