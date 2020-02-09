package gdscript


import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler
import com.intellij.codeInsight.editorActions.QuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.util.TextRange

class ScriptQuoteHandler : QuoteHandler, MultiCharQuoteHandler {

    override fun isClosingQuote(iterator: HighlighterIterator?, offset: Int): Boolean {
        val prev = iterator?.document?.text?.get(offset)
            ?: return false
        return prev != '\'' && prev != '\"'
    }

    override fun getClosingQuote(iterator: HighlighterIterator, offset: Int): CharSequence? =
        iterator.document.getText(TextRange(offset - 1, offset))

    override fun isOpeningQuote(iterator: HighlighterIterator?, offset: Int) =
        true

    override fun hasNonClosedLiteral(editor: Editor?, iterator: HighlighterIterator?, offset: Int) =
        true

    override fun isInsideLiteral(iterator: HighlighterIterator?) =
        true

}
