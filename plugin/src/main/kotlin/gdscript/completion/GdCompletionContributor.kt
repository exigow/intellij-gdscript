package gdscript.completion

import Library
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.*
import gdscript.completion.utilities.PrioritizedLookupCompletionProvider
import gdscript.completion.utilities.Priority


class GdCompletionContributor : CompletionContributor() {

    init {
        val library = Library.load()
        for (clazz in library.classes) {
            when (clazz.name) {
                "@GDScript" -> {
                    val constants = clazz.constants.map { create(it.name).withIcon(FIELD_ICON).withTailText(it.lookupText()) }
                    val methods = clazz.methods.map { create(it.name).withIcon(FUNCTION_ICON).withTailText(it.arguments.joined()).withTypeText(it.type) }
                    extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(constants + methods))
                }
                else -> {
                    extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(listOf(create(clazz.name).withIcon(CLASS_ICON))))
                    val fields = clazz.fields.map { create(it.name).withIcon(VARIABLE_ICON).withTypeText(it.type).bold() }
                    val getters = clazz.fields.map { create(it.getter).withIcon(METHOD_ICON).withTypeText(it.type)}
                    val setters = clazz.fields.map { create(it.setter).withIcon(METHOD_ICON).withTailText("(value: ${it.type})") }
                    val methods = clazz.methods.map { create(it.name).withIcon(METHOD_ICON).withTailText(it.arguments.joined()).withTypeText(it.type) }
                    val constants = clazz.constants.map { create(it.name).withIcon(FIELD_ICON).withTailText(it.lookupText()) }
                    extend(BASIC, psiElement().afterLeaf("."), PrioritizedLookupCompletionProvider(fields + getters + setters + methods + constants))
                }
            }
        }
        extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(KEYWORDS.map { create(it).bold() }, Priority.KEYWORD))
    }

    private fun Library.Class.Constant.lookupText() =
        " = $value"

    private fun List<Library.Class.Method.Argument>.joined() =
        joinToString(", ", "(", ")") { "${it.name}: ${it.type}" }

    companion object {
        val KEYWORDS = arrayOf(
            "if",
            "elif",
            "else",
            "for",
            "while",
            "match",
            "break",
            "continue",
            "pass",
            "return",
            "class",
            "extends",
            "is",
            "as",
            "self",
            "tool",
            "signal",
            "func",
            "static",
            "const",
            "enum",
            "var",
            "onready",
            "export",
            "setget",
            "breakpoint",
            "preload",
            "yield",
            "assert",
            "remote",
            "master",
            "puppet",
            "remotesync",
            "mastersync",
            "puppetsync"
        )
    }
}
