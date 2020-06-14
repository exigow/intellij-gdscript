package gdscript.lexer.scanner

import gdscript.ScriptTokenType.NODE
import gdscript.lexer.Token

class NodeScanner : TokenScanner {

    override fun scanToken(chars: CharSequence, start: Int): Token? {
        val prefix = scanChar(chars, start, '$')
        if (prefix == start)
            return null
        val path = scanWhile(chars, prefix) { Character.isJavaIdentifierPart(it) || it == '/' }
        return Token(start, path, NODE)
    }

}
