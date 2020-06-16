package gdscript.lexer.scanner

import api.GrammarKeywords
import api.VersionedClassesService
import com.intellij.openapi.components.service
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
            in collectKeywords() -> KEYWORD
            in collectClasses() -> CLASS_NAME
            in collectConstants() -> CONSTANT
            else -> {
                if (CONSTANT_REGEX.matches(text))
                    return CONSTANT
                return IDENTIFIER
            }
        }
    }

    private fun collectKeywords(): List<String> {
        val api = service<VersionedClassesService>().current()
        return GrammarKeywords.KEYWORDS + GrammarKeywords.VARIABLE_KEYWORDS + GrammarKeywords.PRIMITIVE_KEYWORDS + api.globals.flatMap { it.methods }.map { it.name }
    }

    private fun collectClasses(): List<String> {
        val api = service<VersionedClassesService>().current()
        return (api.singletons.toList() + api.classes.toList() - api.primitives).map { it.name }
    }

    private fun collectConstants() =
        service<VersionedClassesService>()
            .current()
            .globals.
            flatMap { it.constants }
            .map { it.name }

    private companion object {

        private val CONSTANT_REGEX = "[A-Z][A-Z0-9_]+".toRegex()

    }

}