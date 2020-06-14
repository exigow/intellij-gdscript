package gdscript.lexer.scanner

import gdscript.ScriptTokenType.LINE_COMMENT
import gdscript.lexer.Token

class LineCommentScanner : TokenScanner {

    override fun scanToken(chars: CharSequence, start: Int): Token? {
        val prefix = scanChar(chars, start, '#')
        if (prefix == start)
            return null
        val endOfLine = scanWhile(chars, prefix) { it != '\n' }
        return Token(start, endOfLine, LINE_COMMENT)
    }

}
