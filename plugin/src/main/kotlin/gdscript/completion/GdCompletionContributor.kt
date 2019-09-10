package gdscript.completion

import Library
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.PlatformIcons.*
import gdscript.completion.utilities.PrioritizedLookupCompletionProvider
import gdscript.completion.utilities.Priority
import javax.swing.Icon


class GdCompletionContributor : CompletionContributor() {

    init {
        val library = Library.load()
        for (clazz in library.classes) {
            when (clazz.name) {
                "@GDScript" -> {
                    val constants = clazz.constants.map { it.toLookup() }
                    val methods = clazz.methods.map { it.toLookup() }
                    extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(constants + methods))
                }
                else -> {
                    extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(listOf(create(clazz.name).withIcon(CLASS_ICON))))
                    val fields = clazz.fields.map { create(it.name).withIcon(VARIABLE_ICON).withTypeText(it.type).bold() }
                    val methods = clazz.methods.map { it.toLookup() }
                    val constants = clazz.constants.map { it.toLookup() }
                    extend(BASIC, psiElement().afterLeaf("."), PrioritizedLookupCompletionProvider(fields + methods + constants))
                }
            }
        }
        extend(BASIC, psiElement(), PrioritizedLookupCompletionProvider(KEYWORDS.map { create(it).bold() }, Priority.KEYWORD))
    }

    private fun Library.Class.Method.toLookup() =
        create(name).withIcon(METHOD_ICON).withTailText(arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" }).withTypeText(type)

    private fun Library.Class.Constant.toLookup() =
        create(name).withTailText(" = $value").withIcon(FIELD_ICON)

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
