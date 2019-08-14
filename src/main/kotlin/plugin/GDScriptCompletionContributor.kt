package plugin

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.PlatformIcons.*
import com.intellij.util.ProcessingContext
import plugin.deserialization.DocumentDeserializer
import plugin.deserialization.models.Document
import javax.swing.Icon


class GDScriptCompletionContributor : CompletionContributor() {

    init {
        extendBasic(psiElement(), listOf("var", "const", "if", "while", "return", "extend"))
        for (resourceName in listOf("/docs/Color.xml", "/docs/GDScript.xml", "/docs/Sprite.xml", "/docs/Vector2.xml")) {
            val doc = deserializeDocument(resourceName)
            extendBasic(psiElement(), listOf(doc.name), CLASS_ICON)
            extendBasic(psiElement(), doc.usefulMembersNames(), METHOD_ICON)
            extendBasic(psiElement(), doc.usefulMethodsNames(), METHOD_ICON)
            extendBasic(psiElement(), doc.usefulConstantsNames(), VARIABLE_READ_ACCESS)
        }
    }

    private fun extendBasic(capture: PsiElementPattern.Capture<PsiElement>, words: List<String>, icon: Icon? = null) {
        val completion = object : CompletionProvider<CompletionParameters>() {

            override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                val lookups = words.map { LookupElementBuilder.create(it).withIcon(icon) }
                result.addAllElements(lookups)
            }

        }
        extend(BASIC, capture, completion)
    }

    private fun deserializeDocument(resourceName: String): Document {
        val text = GDScriptCompletionContributor::class.java.getResource(resourceName).readText()
        return DocumentDeserializer().deserializeText(text)
    }

}
