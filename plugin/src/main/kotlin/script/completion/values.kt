package script.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.PlatformIcons

val SELF = createValueLookup("self")
val TRUE = createValueLookup("true")
val FALSE = createValueLookup("false")

private fun createValueLookup(name: String): LookupElement = LookupElementBuilder.create(name)
    .withIcon(PlatformIcons.FIELD_ICON)
    .bold()

