package script.completion

import GodotApi
import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.FUNCTION_ICON

val FUNCTION_CALLS = GLOBAL_SCOPE_CLASSES
    .flatMap { it.methods }
    .map { it.toLookup() }

private fun GodotApi.Class.Method.toLookup() = create(name)
    .withIcon(FUNCTION_ICON)
    .withTypeText(type)
    .withArgumentsTail(arguments)
    .withParenthesesInsertHandler(arguments.isNotEmpty())
    .italics()
