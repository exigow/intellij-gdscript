package gdscript.typing


import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator


class ScriptQuoteHandler : MultiCharQuoteHandler {

    override fun isClosingQuote(iter: HighlighterIterator, offset: Int) = false

    override fun isOpeningQuote(iter: HighlighterIterator, offset: Int) = true

    override fun hasNonClosedLiteral(editor: Editor, iter: HighlighterIterator, offset: Int) = true

    override fun isInsideLiteral(iter: HighlighterIterator) = true

    override fun getClosingQuote(iter: HighlighterIterator, offset: Int) = "\""

}
