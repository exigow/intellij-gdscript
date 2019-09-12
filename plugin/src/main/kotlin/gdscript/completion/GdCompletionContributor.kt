package gdscript.completion

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


class GdCompletionContributor : CompletionContributor() {

    private val library = Library.load()

    init {
        val languageClass = library.classes.find { it.name == "@GDScript" }!!
        val languageFunctionLookups = languageClass.methods
            .map { create(it.name).bold().withIcon(FUNCTION_ICON).withArgumentsTailText(it.arguments).withTypeText(it.type).withInvocationSuffix() }
        extend(psiElement(), languageFunctionLookups)
        val languageConstantLookups = languageClass.constants
            .map { create(it.name).bold().withIcon(FIELD_ICON).withValueTailText(it.value) }
        extend(psiElement(), languageConstantLookups)

        val otherClasses = library.classes - languageClass
        val classNameLookups = otherClasses.map { create(it.name).withIcon(CLASS_ICON) }
        extend(psiElement().afterLeaf("->"), classNameLookups)
        extend(psiElement().afterLeaf("extends"), classNameLookups)
        extend(psiElement().afterLeaf(":"), classNameLookups)
        val fieldLookups = otherClasses.flatMap { it.fields.map { f -> create(f.name).withIcon(VARIABLE_ICON).withTypeText(f.type).bold() } }
        extend(psiElement().afterLeaf("."), fieldLookups)
        val setterLookups = otherClasses.flatMap { it.fields.map { f -> create(f.setter).italics().withIcon(METHOD_ICON).withTailText("(value: ${f.type})") } }
        val getterLookups = otherClasses.flatMap { it.fields.map { f -> create(f.getter).italics().withIcon(METHOD_ICON).withInvocationTailText().withTypeText(f.type).withInvocationSuffix() } }
        extend(psiElement().afterLeaf("."), setterLookups + getterLookups)
        val methodLookups = otherClasses.flatMap { it.methods.map { m -> create(m.name).withIcon(METHOD_ICON).withArgumentsTailText(m.arguments).withTypeText(m.type).withInvocationSuffix() } }
        extend(psiElement().afterLeaf("."), methodLookups)
        val constantLookups = otherClasses.flatMap { it.constants.map { c -> create(c.name).withIcon(FIELD_ICON).withValueTailText(c.value) } }
        extend(psiElement().afterLeaf("."), constantLookups)

        val keywordLookups = listOf(
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
        extend(psiElement(), keywordLookups)
    }

    private fun extend(pattern: PsiElementPattern.Capture<PsiElement>, lookups: List<LookupElement>) {
        val provider = object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                result.addAllElements(lookups)
            }
        }
        return extend(CompletionType.BASIC, pattern, provider)
    }

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

}
