package script.completion

import GodotApi
import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.CLASS_ICON

val SINGLETONS = GLOBAL_SCOPE_CLASSES
    .flatMap { it.fields }
    .map { it.toLookup() }

private fun GodotApi.Class.Field.toLookup() = create(name)
    .withIcon(CLASS_ICON)
    .withTypeText(type)
    .italics()
