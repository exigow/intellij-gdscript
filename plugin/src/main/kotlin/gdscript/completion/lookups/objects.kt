package gdscript.completion.lookups

import GodotApi
import GodotApi.OBJECT_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.CLASS_ICON

val OBJECT_TYPES = OBJECT_CLASSES
    .map { it.toObjectLookup() }

private fun GodotApi.Class.toObjectLookup() = create(name)
    .withTypeText(extends)
    .withIcon(CLASS_ICON)

