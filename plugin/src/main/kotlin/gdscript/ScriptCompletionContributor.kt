package gdscript

import Library
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

    private val library = Library.load()

    init {
        val language = library.classes.find { it.name == "@GDScript" }!!
        extend(psiElement(), language.methods.map { createLanguageFunctionLookup(it) })
        extend(psiElement(), language.constants.map { createLanguageConstantLookup(it) })
        val otherClasses = library.classes - language
        extend(psiElement().afterLeaf("->"), otherClasses.map { createClassLookup(it) })
        extend(psiElement().afterLeaf("extends"), otherClasses.map { createClassLookup(it) })
        extend(psiElement().afterLeaf(":"), otherClasses.map { createClassLookup(it) })
        extend(psiElement().afterLeaf("."), otherClasses.flatMap { c -> c.fields.map { createFieldLookups(it) } })
        extend(psiElement().afterLeaf("."), otherClasses.flatMap { c -> c.fields.flatMap { listOf(createSetterLookups(it), createGetterLookups(it)) } })
        extend(psiElement().afterLeaf("."), otherClasses.flatMap { c -> c.methods.map { createMethodLookups(it) } })
        extend(psiElement().afterLeaf("."), otherClasses.flatMap { c -> c.constants.map { createConstantLookups(it) } })
        extend(psiElement(), createKeywordLookups())
    }

    private fun extend(pattern: PsiElementPattern.Capture<PsiElement>, lookups: List<LookupElement>) =
        extend(CompletionType.BASIC, pattern, LookupCompletionProvider(lookups))

    private fun createLanguageFunctionLookup(it: Library.Class.Method) = create(it.name)
        .bold()
        .withIcon(FUNCTION_ICON)
        .withArgumentsTailText(it.arguments)
        .withTypeText(it.type)
        .withInvocationSuffix()

    private fun createLanguageConstantLookup(it: Library.Class.Constant) = create(it.name)
        .bold()
        .withIcon(FIELD_ICON)
        .withValueTailText(it.value)

    private fun createClassLookup(clazz: Library.Class) = create(clazz.name)
        .withIcon(CLASS_ICON)

    private fun createFieldLookups(field: Library.Class.Field) = create(field.name)
        .withIcon(VARIABLE_ICON)
        .withTypeText(field.type)
        .bold()

    private fun createSetterLookups(field: Library.Class.Field) = create(field.setter)
        .italics()
        .withIcon(METHOD_ICON)
        .withTailText("(value: ${field.type})")

    private fun createGetterLookups(field: Library.Class.Field) = create(field.getter)
        .italics()
        .withIcon(METHOD_ICON)
        .withInvocationTailText()
        .withTypeText(field.type)
        .withInvocationSuffix()

    private fun createMethodLookups(method: Library.Class.Method) = create(method.name)
        .withIcon(METHOD_ICON)
        .withArgumentsTailText(method.arguments)
        .withTypeText(method.type)
        .withInvocationSuffix()

    private fun createConstantLookups(constant: Library.Class.Constant) = create(constant.name)
        .withIcon(FIELD_ICON)
        .withValueTailText(constant.value)


    private fun LookupElementBuilder.withInvocationTailText() =
        withTailText("()")

    private fun LookupElementBuilder.withStatementTailText() =
        withTailText(" ...:")

    private fun LookupElementBuilder.withValueTailText(value: String) =
        withTailText(" = $value")

    private fun LookupElementBuilder.withArgumentsTailText(arguments: List<Library.Class.Method.Argument>) =
        withTailText(arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" })

    private fun LookupElementBuilder.withInvocationSuffix() =
        withSuffix("()", move = 1)

    private fun LookupElementBuilder.withStatementSuffix() =
        withSuffix(" :", move = 1)

    private fun LookupElementBuilder.withSpaceSuffix() =
        withSuffix(" ", move = 1)

    private fun LookupElementBuilder.italics() =
        withItemTextItalic(true)

    private fun LookupElementBuilder.withSuffix(suffix: String, move: Int) =
        withInsertHandler { ctx, _ ->
        ctx.document.insertString(ctx.selectionEndOffset, suffix)
        EditorModificationUtil.moveCaretRelatively(ctx.editor, move)
    }

    private fun createKeywordLookups() = listOf(
        create("if").bold().withStatementTailText().withStatementSuffix(),
        create("elif").bold().withStatementTailText().withStatementSuffix(),
        create("else").bold().withTailText(":").withSuffix(":", move =  1),
        create("for").bold().withStatementTailText().withStatementSuffix(),
        create("while").bold().withStatementTailText().withStatementSuffix(),
        create("match").bold().withStatementTailText().withStatementSuffix(),
        create("break").bold(),
        create("continue").bold(),
        create("pass").bold(),
        create("return").bold().withSpaceSuffix(),
        create("class").bold().withSpaceSuffix(),
        create("class_name").bold().withSpaceSuffix(),
        create("extends").bold().withSpaceSuffix(),
        create("is").bold().withSpaceSuffix(),
        create("as").bold().withSpaceSuffix(),
        create("self").bold(),
        create("tool").bold(),
        create("signal").bold().withSpaceSuffix(),
        create("func").bold().withSpaceSuffix(),
        create("static").bold().withSpaceSuffix(),
        create("const").bold().withSpaceSuffix(),
        create("enum").bold().withTailText(" {...}").withSuffix(" {}", move = 2),
        create("var").bold().withSpaceSuffix(),
        create("onready").bold().withSpaceSuffix(),
        create("export").bold().withInvocationTailText().withInvocationSuffix(),
        create("setget").bold().withSpaceSuffix(),
        create("breakpoint").bold(),
        create("load").bold().withInvocationTailText().withInvocationSuffix(),
        create("preload").bold().withInvocationTailText().withInvocationSuffix(),
        create("yield").bold().withInvocationTailText().withInvocationSuffix(),
        create("assert").bold().withInvocationTailText().withInvocationSuffix(),
        create("remote").bold().withSpaceSuffix(),
        create("master").bold().withSpaceSuffix(),
        create("puppet").bold().withSpaceSuffix(),
        create("remotesync").bold(),
        create("mastersync").bold(),
        create("puppetsync").bold()
    )

    private inner class LookupCompletionProvider(private val lookups: List<LookupElement>) : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            result.addAllElements(lookups)
        }

    }

}
