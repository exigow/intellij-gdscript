package gdscript.completion.lookups

import GodotApi
import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.VARIABLE_ICON

val CONSTANTS = GLOBAL_SCOPE_CLASSES
    .flatMap { it.constants }
    .map { it.toLookup() }

private fun GodotApi.Class.Constant.toLookup() = create(name)
    .withIcon(VARIABLE_ICON)
    .withTailText(" = $value")
