package gdscript


import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import gdscript.ScriptLexer.STRING_APHOSTROPHE
import gdscript.ScriptLexer.STRING_DOUBLE_QUOTE
import org.antlr.intellij.adaptor.lexer.TokenIElementType


class ScriptQuoteHandler : SimpleTokenSetQuoteHandler(ScriptTokenSet.STRINGS), MultiCharQuoteHandler {

    override fun getClosingQuote(iterator: HighlighterIterator, offset: Int): CharSequence? {
        val token = recognizeTokenOnPosition(iterator)
        return matchClosingCharacter(token)
    }

    private fun matchClosingCharacter(token: Int?) = when (token) {
        STRING_DOUBLE_QUOTE -> "\""
        STRING_APHOSTROPHE -> "\'"
        else -> null
    }

    private fun recognizeTokenOnPosition(iterator: HighlighterIterator) =
        (iterator.tokenType as? TokenIElementType)?.antlrTokenType

}
