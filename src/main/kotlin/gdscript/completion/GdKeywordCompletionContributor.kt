package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import gdscript.completion.utilities.LookupCompletionProvider

class GdKeywordCompletionContributor : CompletionContributor() {

    init {
        for (keyword in getKeywords()) {
            val lookup = LookupElementBuilder.create(keyword).bold()
            extend(BASIC, psiElement(), LookupCompletionProvider(lookup))
        }
    }

    private fun getKeywords() = listOf(
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

}