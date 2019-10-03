package script

import GodotApi
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.PlatformIcons.*
import com.intellij.util.ProcessingContext


class ScriptCompletionContributor : CompletionContributor() {

    init {
        extend(psiElement(), LANGUAGE_CLASS.methods.map { createLanguageFunctionLookup(it) })
        extend(psiElement(), LANGUAGE_CLASS.constants.map { createLanguageConstantLookup(it) })
        extend(psiElement().afterLeaf("->"), COMMON_CLASS.map { createClassLookup(it) })
        extend(psiElement().afterLeaf("extends"), COMMON_CLASS.map { createClassLookup(it) })
        extend(psiElement().afterLeaf(":"), COMMON_CLASS.map { createClassLookup(it) })
        extend(psiElement().afterLeaf("."), COMMON_CLASS.flatMap { c -> c.fields.map { createFieldLookups(it) } })
        extend(psiElement().afterLeaf("."), COMMON_CLASS.flatMap { c -> c.fields.flatMap { listOf(createSetterLookups(it), createGetterLookups(it)) } })
        extend(psiElement().afterLeaf("."), COMMON_CLASS.flatMap { c -> c.methods.map { createMethodLookups(it) } })
        extend(psiElement().afterLeaf("."), COMMON_CLASS.flatMap { c -> c.constants.map { createConstantLookups(it) } })
        extend(psiElement(), createKeywordLookups())
    }

    private fun extend(pattern: PsiElementPattern.Capture<PsiElement>, lookups: List<LookupElement>) =
        extend(CompletionType.BASIC, pattern, LookupCompletionProvider(lookups))

    private fun createLanguageFunctionLookup(method: GodotApi.Class.Method) = create(method.name)
        .withIcon(FUNCTION_ICON)
        .withTailText(joinArguments(method.arguments))
        .withTypeText(method.type)
        .bold()
        .withAutoTyping("(", ")")

    private fun createLanguageConstantLookup(constant: GodotApi.Class.Constant) = create(constant.name)
        .withIcon(FIELD_ICON)
        .withTailText(" = ${constant.value}")
        .bold()

    private fun createClassLookup(clazz: GodotApi.Class) = create(clazz.name)
        .withIcon(CLASS_ICON)

    private fun createFieldLookups(field: GodotApi.Class.Field) = create(field.name)
        .withIcon(VARIABLE_ICON)
        .withTypeText(field.type)
        .bold()

    private fun createSetterLookups(field: GodotApi.Class.Field) = create(field.setter)
        .withIcon(METHOD_ICON)
        .withTailText("(value: ${field.type})")
        .withAutoTyping("(", ")")
        .withItemTextItalic(true)

    private fun createGetterLookups(field: GodotApi.Class.Field) = create(field.getter)
        .withIcon(METHOD_ICON)
        .withTypeText(field.type)
        .withItemTextItalic(true)
        .withTailText("()")
        .withAutoTyping("()")

    private fun createMethodLookups(method: GodotApi.Class.Method) = create(method.name)
        .withIcon(METHOD_ICON)
        .withTailText(joinArguments(method.arguments))
        .withTypeText(method.type)
        .withAutoTyping("(", ")")

    private fun createConstantLookups(constant: GodotApi.Class.Constant) = create(constant.name)
        .withIcon(FIELD_ICON)
        .withTailText(" = ${constant.value}")

    private fun createKeywordLookups() = listOf(
        createKeyword("if", SPACE, ":"),
        createKeyword("elif", SPACE, ":"),
        createKeyword("else", ":"),
        createKeyword("for", SPACE, ":"),
        createKeyword("while", SPACE, ":"),
        createKeyword("match", SPACE, ":"),
        createKeyword("break"),
        createKeyword("continue"),
        createKeyword("pass"),
        createKeyword("return", SPACE),
        createKeyword("class", SPACE),
        createKeyword("class_name", SPACE),
        createKeyword("extends", SPACE),
        createKeyword("is", SPACE),
        createKeyword("as", SPACE),
        createKeyword("self"),
        createKeyword("tool"),
        createKeyword("signal", SPACE),
        createKeyword("func", SPACE),
        createKeyword("static", SPACE),
        createKeyword("const", SPACE),
        createKeyword("enum", " {", "}"),
        createKeyword("var", SPACE),
        createKeyword("onready", SPACE),
        createKeyword("export", SPACE),
        createKeyword("setget", SPACE),
        createKeyword("breakpoint"),
        createKeyword("remote", SPACE),
        createKeyword("master", SPACE),
        createKeyword("puppet", SPACE),
        createKeyword("remotesync"),
        createKeyword("mastersync"),
        createKeyword("puppetsync")
    )

    private fun createKeyword(name: String, typing: String = "", postfix: String = "") =
        create(name)
        .withTailText(joinKeyword(typing, postfix))
        .bold()
        .withAutoTyping(typing, postfix)

    private fun joinKeyword(typing: String, postfix: String): String =
        if (typing.isBlank())
            ""
        else
            "$typing...$postfix"

    private fun LookupElementBuilder.withAutoTyping(typing: String, postfix: String = "") =
        withInsertHandler { ctx, _ ->
            ctx.document.insertString(ctx.selectionEndOffset, typing + postfix)
            EditorModificationUtil.moveCaretRelatively(ctx.editor, typing.length)
        }

    private fun joinArguments(arguments: List<GodotApi.Class.Method.Argument>) =
        arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" }

    private class LookupCompletionProvider(private val lookups: List<LookupElement>) : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            result.addAllElements(lookups)
        }

    }

    private companion object {

        const val SPACE = " "
        val LANGUAGE_CLASS = GodotApi.CLASSES.find { it.name == "@GDScript" }!!
        val COMMON_CLASS = GodotApi.CLASSES.asList() - LANGUAGE_CLASS

    }

}
