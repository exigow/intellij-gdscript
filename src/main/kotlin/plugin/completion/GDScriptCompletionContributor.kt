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
import plugin.completion.deserialization.DocumentationDeserializer
import plugin.completion.deserialization.models.Documentation
import plugin.completion.deserialization.utilities.ColorParser
import plugin.icons.IconFactory
import javax.swing.Icon


class GDScriptCompletionContributor : CompletionContributor() {

    init {
        extendDocumentation()
        extendColor()
        extendKeyword()

        extendBasic(psiElement(), "test", CLASS_ICON)
    }

    private fun extendDocumentation() {
        val paths = listOf(
            "/docs/GDScript.xml",
            "/docs/Sprite.xml",
            "/docs/Vector2.xml",
            "/docs/String.xml"
        )
        for (path in paths) {
            val doc = deserializeDocument(path)
            extendBasic(psiElement(), doc.name, CLASS_ICON)
            extendBasic(psiElement(), doc.usefulMembersNames(), METHOD_ICON)
            extendBasic(psiElement(), doc.usefulMethodsNames(), METHOD_ICON)
            extendBasic(psiElement(), doc.usefulConstantsNames(), VARIABLE_READ_ACCESS)
        }
    }

    private fun extendColor() {
        val doc = deserializeDocument("/docs/Color.xml")
        for (constant in doc.constants!!) {
            val name = constant.name
            val color = ColorParser.parse(constant.value)
            val icon = IconFactory.fromColor(color)
            extendBasic(psiElement(), name, icon)
        }
    }

    private fun extendKeyword() {
        val keywords = listOf(
            "if",
            "elif",
            "else",
            "for",
            "while",
            "match",
            "break",
            "continue",
            "pass",
            "return",
            "class",
            "extends",
            "is",
            "as",
            "self",
            "tool",
            "signal",
            "func",
            "static",
            "const",
            "enum",
            "var",
            "onready",
            "export",
            "setget",
            "breakpoint",
            "preload",
            "yield",
            "assert",
            "remote",
            "master",
            "puppet",
            "remotesync",
            "mastersync",
            "puppetsync"
        )
        extendBasic(psiElement(), keywords, CLASS_ICON)
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

    private fun deserializeDocument(resourceName: String): Documentation {
        val text = GDScriptCompletionContributor::class.java.getResource(resourceName).readText()
        return DocumentationDeserializer.deserializeText(text)
    }

}
