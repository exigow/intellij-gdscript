package plugin

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import plugin.parser.GDScriptParser


class GDScriptCompletionContributor : CompletionContributor() {

    init {
        val placeEverywhere = PlatformPatterns.psiElement().withLanguage(GDScript)
        val keywordProvider = createKeywordCompletionProvider()
        extend(CompletionType.BASIC, placeEverywhere, keywordProvider)
    }

    private fun createKeywordCompletionProvider() = object : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            val keywordLookups = createKeywordLiteralLookups()
            result.addAllElements(keywordLookups)
        }

    }

    private fun createKeywordLiteralLookups(): List<LookupElement> {
        val tokenValues = listOf(
            GDScriptParser.VAR,
            GDScriptParser.CONST,
            GDScriptParser.EXTENDS,
            GDScriptParser.IF,
            GDScriptParser.WHILE
        )
        return tokenValues
            .map { GDScriptParser.VOCABULARY.getLiteralName(it) }
            .map(::removeSurroundingApostrophes)
            .map { LookupElementBuilder.create(it) }
    }

    private fun removeSurroundingApostrophes(literal: String) = literal.substring(1..(literal.length - 2))

}
