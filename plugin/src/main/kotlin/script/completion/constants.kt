package script.completion

import GodotApi
import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.VARIABLE_ICON

val CONSTANTS = GLOBAL_SCOPE_CLASSES
    .flatMap { it.constants }
    .map { createConstant(it) }

private fun createConstant(it: GodotApi.Class.Constant) = create(it.name)
    .withIcon(VARIABLE_ICON)
    .withTailText(" = ${it.value}")
    .italics()
    .bold()
