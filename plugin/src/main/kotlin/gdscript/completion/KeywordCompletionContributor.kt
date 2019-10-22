package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.lookups.KeywordLookups.createKeyword
import gdscript.completion.lookups.KeywordLookups.createKeywordSpaced
import gdscript.completion.providers.CaseSensitiveLookupProvider


class KeywordCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement().afterLeaf("\n"), CaseSensitiveLookupProvider(STATEMENT_LOOKUPS))
        extend(BASIC, psiElement().afterLeaf("\n"), CaseSensitiveLookupProvider(NO_ARGUMENT_STATEMENT_LOOKUPS))
        extend(BASIC, psiElement().afterLeaf("export"), CaseSensitiveLookupProvider(createKeywordSpaced("var")))
        extend(BASIC, psiElement().afterLeaf("static"), CaseSensitiveLookupProvider(createKeywordSpaced("func")))
    }
    
    private companion object {
        val STATEMENT_LOOKUPS = listOf(
            "remote",
            "sync",
            "var",
            "const",
            "func",
            "for",
            "while",
            "class",
            "extends",
            "class_name",
            "enum",
            "if",
            "elif",
            "else",
            "return",
            "signal",
            "export",
            "static",
            "puppet",
            "master",
            "match"
        ).map { createKeywordSpaced(it) }
        val NO_ARGUMENT_STATEMENT_LOOKUPS = listOf(
            "tool",
            "pass",
            "break",
            "continue"
        ).map { createKeyword(it) }
    }

}
