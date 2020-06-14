package gdscript.lexer.scanner

import com.intellij.psi.tree.IElementType
import gdscript.ScriptTokenType.CLASS_NAME
import gdscript.ScriptTokenType.CONSTANT
import gdscript.ScriptTokenType.IDENTIFIER
import gdscript.ScriptTokenType.KEYWORD
import gdscript.completion.sources.CompletionDictionary
import gdscript.lexer.Token

class IdentifierScanner : TokenScanner {

    override fun scanToken(chars: CharSequence, start: Int): Token? {
        val idStart = scanWhile(chars, start, Character::isJavaIdentifierStart)
        if (start == idStart)
            return null
        val end = scanWhile(chars, idStart, Character::isJavaIdentifierPart)
        if (start == end)
            return null
        val type = recognizeType(chars.substring(start, end))
        return Token(start, end, type)
    }

    private fun recognizeType(text: String): IElementType {
        return when (text) {
            in CompletionDictionary.KEYWORDS,
            in CompletionDictionary.VARIABLE_KEYWORDS,
            in CompletionDictionary.FUNCTION_NAMES -> KEYWORD
            in CompletionDictionary.NON_PRIMITIVE_CLASS_NAMES -> CLASS_NAME
            in CompletionDictionary.LANGUAGE_CONSTANT_NAMES -> CONSTANT
            else -> IDENTIFIER
        }
    }

}