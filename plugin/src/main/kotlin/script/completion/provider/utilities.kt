package script.completion.provider

import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.openapi.editor.EditorModificationUtil
import kotlin.math.min


internal fun InsertionContext.hasNoOpenBraceAfterCaret() =
    file.text[min(tailOffset, file.text.length - 1)] != '('

internal fun InsertionContext.insert(text: String) =
    document.insertString(selectionEndOffset, text)

internal fun InsertionContext.moveCaret(steps: Int) =
    EditorModificationUtil.moveCaretRelatively(editor, steps)