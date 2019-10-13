package script.completion

import GodotApi
import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.PlatformIcons

val SINGLETONS = GLOBAL_SCOPE_CLASSES
    .flatMap { it.fields }
    .map { createSingleton(it) }

private fun createSingleton(it: GodotApi.Class.Field) = LookupElementBuilder.create(it.name)
    .withIcon(PlatformIcons.CLASS_ICON)
    .withTypeText(it.type)
    .italics()
