package script.completion

import GodotApi
import GodotApi.GLOBAL_SCOPE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons

val FUNCTION_CALLS = GLOBAL_SCOPE_CLASSES
    .flatMap { it.methods }
    .map { createFunctionCall(it) }

private fun createFunctionCall(it: GodotApi.Class.Method) = create(it.name)
    .withIcon(PlatformIcons.FUNCTION_ICON)
    .withTypeText(it.type)
    .withArgumentsTail(it.arguments)
    .withParenthesesInsertHandler(hasArguments = it.arguments.isNotEmpty())
    .italics()
