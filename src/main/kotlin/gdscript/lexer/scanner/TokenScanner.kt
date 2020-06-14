package gdscript.lexer.scanner

import gdscript.lexer.Token

interface TokenScanner {

    fun scanToken(chars: CharSequence, start: Int): Token?

}