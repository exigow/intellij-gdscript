package script.completion

import GodotApi
import GodotApi.OBJECT_CLASSES
import GodotApi.PRIMITIVE_CLASSES
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.util.PlatformIcons.CLASS_ICON

val CONSTRUCTOR_CALLS = (OBJECT_CLASSES + PRIMITIVE_CLASSES)
    .flatMap { clazz -> clazz.methods.filter { it.name == clazz.name } }
    .map { it.toLookup() }

private fun GodotApi.Class.Method.toLookup() = create(name)
    .withIcon(CLASS_ICON)
    .withTypeText(type)
    .withArgumentsTail(arguments)
    .withParenthesesInsertHandler(arguments.isNotEmpty())
