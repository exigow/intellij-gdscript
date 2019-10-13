package script.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.PlatformIcons.FIELD_ICON

val SELF_TRUE_FALSE = listOf("self", "true", "false")
    .map { createLookup(it) }

private fun createLookup(name: String): LookupElement = LookupElementBuilder.create(name)
    .withIcon(FIELD_ICON)
    .bold()

