package gdscript.lexer.scanner

import gdscript.ScriptTokenType
import gdscript.lexer.Token

class WhitespaceScanner : TokenScanner {

    override fun scanToken(chars: CharSequence, start: Int): Token? {
        val end = scanWhile(chars, start, Character::isWhitespace)
        if (start == end)
            return null
        return Token(start, end, ScriptTokenType.WHITESPACE)
    }

}