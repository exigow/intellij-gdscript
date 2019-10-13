package script.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder

val VALUES = listOf("self", "true", "false", "null")
    .map { createLookup(it) }

private fun createLookup(name: String): LookupElement = LookupElementBuilder.create(name)
    .bold()

