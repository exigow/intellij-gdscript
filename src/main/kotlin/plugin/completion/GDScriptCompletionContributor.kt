package plugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern.Capture
import com.intellij.psi.PsiElement
import com.intellij.util.PlatformIcons.*
import com.intellij.util.ProcessingContext
import plugin.completion.deserialization.ColorDeserializer
import plugin.completion.deserialization.DocumentDeserializer
import plugin.completion.deserialization.models.Document
import plugin.icons.GDScriptIconFactory
import javax.swing.Icon


class GDScriptCompletionContributor : CompletionContributor() {

    init {
        extendBasic(psiElement(), listOf("var", "const", "if", "while", "return", "extend"), CLASS_ICON)
        for (resourceName in listOf("/docs/GDScript.xml", "/docs/Sprite.xml", "/docs/Vector2.xml", "/docs/String.xml")) {
            val doc = deserializeDocument(resourceName)
            extendBasic(psiElement(), doc.name, CLASS_ICON)
            extendBasic(psiElement(), doc.usefulMembersNames(), METHOD_ICON)
            extendBasic(psiElement(), doc.usefulMethodsNames(), METHOD_ICON)
            extendBasic(psiElement(), doc.usefulConstantsNames(), VARIABLE_READ_ACCESS)
        }
        for (constant in deserializeDocument("/docs/Color.xml").constants!!) {
            val name = constant.name
            val color = ColorDeserializer.deserialize(constant.value)
            val icon = GDScriptIconFactory.createColor(color)
            extendBasic(psiElement(), name, icon)
        }
    }

    private fun extendBasic(capture: Capture<PsiElement>, word: String, icon: Icon) = extendBasic(capture, listOf(word), icon)

    private fun extendBasic(capture: Capture<PsiElement>, words: List<String>, icon: Icon) {
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
        return DocumentDeserializer.deserializeText(text)
    }

}
