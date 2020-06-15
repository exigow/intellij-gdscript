package gdscript.lexer.scanner

import classes.CompletionDictionary
import classes.GDScriptGrammar
import com.intellij.psi.tree.IElementType
import gdscript.ScriptTokenType.CLASS_NAME
import gdscript.ScriptTokenType.CONSTANT
import gdscript.ScriptTokenType.IDENTIFIER
import gdscript.ScriptTokenType.KEYWORD
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
            in GDScriptGrammar.KEYWORDS,
            in GDScriptGrammar.VARIABLE_KEYWORDS,
            in GDScriptGrammar.PRIMITIVE_KEYWORDS,
            in CompletionDictionary.GLOBAL_METHODS.map { it.name }.toSet() -> KEYWORD
            in (CompletionDictionary.ALL_CLASSES.toList() - CompletionDictionary.PRIMITIVE_CLASSES).map { it.name } -> CLASS_NAME
            in CompletionDictionary.GLOBAL_CONSTANTS.map { it.name } -> CONSTANT
            else -> {
                if (CONSTANT_REGEX.matches(text))
                    return CONSTANT
                return IDENTIFIER
            }
        }
    }

    private companion object {

        val CONSTANT_REGEX = "[A-Z][A-Z0-9_]+".toRegex()

    }

}