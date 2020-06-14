package gdscript

import com.intellij.codeInsight.editorActions.QuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.psi.tree.IElementType

class ScriptQuoteHandler : QuoteHandler {

    override fun isClosingQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        val tokenType = iterator.tokenType
        if (tokenType === ScriptTokenType.DOUBLE_QUOTED_STRING || tokenType === ScriptTokenType.SINGLE_QUOTED_STRING) {
            val start = iterator.start
            val end = iterator.end
            return end - start >= 1 && offset == end - 1
        }
        return false
    }

    override fun isOpeningQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        if (iterator.tokenType === ScriptTokenType.DOUBLE_QUOTED_STRING || iterator.tokenType === ScriptTokenType.SINGLE_QUOTED_STRING) {
            val start = iterator.start
            return offset == start
        }
        return false
    }

    override fun hasNonClosedLiteral(editor: Editor, iterator: HighlighterIterator, offset: Int): Boolean {
        try {
            val doc = editor.document
            val chars = doc.charsSequence
            val lineEnd = doc.getLineEndOffset(doc.getLineNumber(offset))
            while (!iterator.atEnd() && iterator.start < lineEnd) {
                if (iterator.tokenType === ScriptTokenType.DOUBLE_QUOTED_STRING || iterator.tokenType === ScriptTokenType.SINGLE_QUOTED_STRING) {
                    if (iterator.start >= iterator.end - 1 ||
                        chars[iterator.end - 1] != '\"' && chars[iterator.end - 1] != '\'') {
                        return true
                    }
                }
                iterator.advance()
            }
        } finally {
            while (!iterator.atEnd() && iterator.start != offset) iterator.retreat()
        }
        return false
    }

    override fun isInsideLiteral(iterator: HighlighterIterator): Boolean =
        iterator.tokenType === ScriptTokenType.DOUBLE_QUOTED_STRING
            || iterator.tokenType === ScriptTokenType.SINGLE_QUOTED_STRING

    companion object {

        fun getLimitingQuote(quotedToken: IElementType): Char {
            return if (quotedToken === ScriptTokenType.DOUBLE_QUOTED_STRING) '"' else if (quotedToken === ScriptTokenType.SINGLE_QUOTED_STRING ||
                quotedToken === ScriptTokenType.UNRECOGNIZED) {
                '\''
            } else throw RuntimeException()
        }
    }

}