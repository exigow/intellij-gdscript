package lsp.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.components.service
import lsp.LanguageServerService
import org.eclipse.lsp4j.CompletionItem
import org.eclipse.lsp4j.CompletionItemKind.*
import com.intellij.codeInsight.completion.CompletionContributor as BaseCompletionContributor

class CompletionContributor : BaseCompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        fetchCompletionItems(parameters)
            .filter { isCurrentFile(it, parameters) }
            .map(::convertToLookup)
            .forEach(result::addElement)
    }

    private fun fetchCompletionItems(parameters: CompletionParameters): List<CompletionItem> {
        val position = parameters.editor.offsetToLogicalPosition(parameters.offset)
        val service = parameters.editor.project?.service<LanguageServerService>()
        return service?.completion(parameters.originalFile.virtualFile, position.line, position.column)!!
    }

    private fun isCurrentFile(item: CompletionItem, parameters: CompletionParameters): Boolean {
        val data = item.data.toString()
        val filename = parameters.originalFile.name
        return data.contains(filename)
    }

    private fun convertToLookup(item: CompletionItem): LookupElement {
        val text = item.label
        return when(item.kind) {
            Text -> LookupElementBuilder.create(text).bold()
            Method -> LookupElementBuilder.create(text).withIcon(AllIcons.Nodes.Method)
            Property -> LookupElementBuilder.create(text).withIcon(AllIcons.Nodes.Variable)
            Class -> LookupElementBuilder.create(text).withIcon(AllIcons.Nodes.Class)
            Constant -> LookupElementBuilder.create(text).withIcon(AllIcons.Nodes.Constant)
            else ->LookupElementBuilder.create(text)
        }
    }

}