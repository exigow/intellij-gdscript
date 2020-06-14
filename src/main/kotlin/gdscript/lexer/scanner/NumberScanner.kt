package gdscript.lexer.scanner

import gdscript.ScriptTokenType.NUMBER
import gdscript.lexer.Token

class NumberScanner : TokenScanner {

    override fun scanToken(chars: CharSequence, start: Int): Token? {
        val minus = scanChar(chars, start, '-')
        val digits = scanWhile(chars, minus, Character::isDigit)
        if (digits == minus)
            return null
        val decimalDot = scanChar(chars, digits, '.')
        val decimalDigits = scanWhile(chars, decimalDot, Character::isDigit)
        val scientificLetter = scanChar(chars, decimalDigits, 'e')
        val scientificMinus = scanChar(chars, scientificLetter, '-')
        val scientificDigits = scanWhile(chars, scientificMinus, Character::isDigit)
        if (scientificDigits == scientificMinus)
            return Token(start, decimalDigits, NUMBER)
        return Token(start, scientificDigits, NUMBER)
    }

}