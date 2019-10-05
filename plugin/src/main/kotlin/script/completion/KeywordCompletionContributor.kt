package script.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.util.ProcessingContext


class KeywordCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC, psiElement(), BasicLookupProvider(create("if").withStatementCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("elif").withStatementCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("else").withElseCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("for").withStatementCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("while").withStatementCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("match").withStatementCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("break").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("continue").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("pass").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("return").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("class").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("class_name").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("extends").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("is").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("as").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("tool").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("signal").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("func").withStatementCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("static").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("const").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("enum").withEnumCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("var").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("onready").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("export").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("setget").withSpaceCompletion()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("breakpoint").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("remote").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("master").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("puppet").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("remotesync").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("mastersync").bold()))
        extend(BASIC, psiElement(), BasicLookupProvider(create("puppetsync").bold()))
    }

    private fun LookupElementBuilder.withStatementCompletion() =
        withTailText(" ...:").withAutoTyping(" $CARET:").bold()

    private fun LookupElementBuilder.withEnumCompletion() =
        withTailText(" {...}").withAutoTyping(" {$CARET}").bold()

    private fun LookupElementBuilder.withElseCompletion() =
        withTailText(":").withAutoTyping(":$CARET").bold()

    private fun LookupElementBuilder.withSpaceCompletion() =
        withTailText(" ...").withAutoTyping(" $CARET").bold()

    private fun LookupElementBuilder.withAutoTyping(typing: String) =
        withInsertHandler { ctx, _ ->
            val lengthToCaret = typing.indexOf(CARET)
            val noCaret = typing.removeRange(lengthToCaret, lengthToCaret + CARET.length)
            ctx.document.insertString(ctx.selectionEndOffset, noCaret)
            EditorModificationUtil.moveCaretRelatively(ctx.editor, lengthToCaret)
        }

    private class BasicLookupProvider(private val lookup: LookupElement) : CompletionProvider<CompletionParameters>() {

        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
            result.addElement(lookup)
        }

    }

    companion object {
        const val CARET = "<caret>"
    }

}
