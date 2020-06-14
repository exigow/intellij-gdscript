package gdscript.lexer.scanner

import com.intellij.psi.tree.IElementType
import gdscript.ScriptTokenType.DOUBLE_QUOTED_STRING
import gdscript.ScriptTokenType.SINGLE_QUOTED_STRING
import gdscript.lexer.Token

class StringScanner : TokenScanner {

    override fun scanToken(chars: CharSequence, start: Int): Token? {
        return scanString(chars, start, '\"', DOUBLE_QUOTED_STRING)
            ?: scanString(chars, start, '\'', SINGLE_QUOTED_STRING)
    }

    private fun scanString(chars: CharSequence, start: Int, decoratorChar: Char, type: IElementType): Token? {
        val prefix = scanChar(chars, start, decoratorChar)
        if (prefix == start)
            return null
        val suffix = scanUntil(chars, prefix) { it == '\n' || it == decoratorChar }
        val closingQuote = scanChar(chars, suffix, decoratorChar)
        return Token(start, closingQuote, type)
    }

}
