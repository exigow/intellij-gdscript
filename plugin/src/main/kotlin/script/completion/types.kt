package script.completion

import GodotApi
import GodotApi.OBJECT_CLASSES
import GodotApi.PRIMITIVE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.CLASS_ICON

val OBJECT_TYPES = OBJECT_CLASSES.map { it.createClass() }
val PRIMITIVE_TYPES = PRIMITIVE_CLASSES.map { it.toPrimitiveLookup() }

private fun GodotApi.Class.createClass() = create(name)
    .withTypeText(extends)
    .withCaseSensitivity(false)
    .withIcon(CLASS_ICON)

private fun GodotApi.Class.toPrimitiveLookup() = create(name)
    .withCaseSensitivity(false)
    .bold()


