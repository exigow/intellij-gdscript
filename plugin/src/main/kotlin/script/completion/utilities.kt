package script.completion

import GodotApi
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.editor.EditorModificationUtil
import kotlin.math.min

internal fun LookupElementBuilder.italics() =
    withItemTextItalic(true)

internal fun LookupElementBuilder.withArgumentsTail(arguments: List<GodotApi.Class.Method.Argument> = emptyList()) =
    withTailText(arguments.joinToString(", ", "(", ")") { "${it.name}: ${it.type}" })

internal fun LookupElementBuilder.withParenthesesInsertHandler(hasArguments: Boolean = false): LookupElementBuilder {
    val handler = object : ParenthesesInsertHandler<LookupElement>() {
        override fun placeCaretInsideParentheses(context: InsertionContext, item: LookupElement) = hasArguments
    }
    return withInsertHandler(handler)
}

internal fun InsertionContext.hasNextCharacter(character: Char) =
    file.text[min(tailOffset, file.text.length - 1)] == character

internal fun InsertionContext.insert(text: String) =
    document.insertString(selectionEndOffset, text)

internal fun InsertionContext.moveCaret(steps: Int) =
    EditorModificationUtil.moveCaretRelatively(editor, steps)
