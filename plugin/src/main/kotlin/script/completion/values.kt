package script.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.PlatformIcons.FIELD_ICON

val SELF = createLookup("self")
val TRUE = createLookup("true")
val FALSE = createLookup("false")

private fun createLookup(name: String): LookupElement = LookupElementBuilder.create(name)
    .withIcon(FIELD_ICON)
    .bold()

