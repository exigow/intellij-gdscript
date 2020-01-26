package gdscript.lexer

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import gdscript.ScriptLexer
import gdscript.ScriptLexer.*
import gdscript.lang.ScriptLanguage
import junit.framework.TestCase

class ScriptLexerTest : TestCase() {

    fun `test var keyword`() =
        assertHasToken("var x", Token(VAR, "var"))

    fun `test string`() =
        assertHasToken("x = \"text\"", Token(STRING_DOUBLE_QUOTE, "\"text\""))

    fun `test string apostrophe`() =
        assertHasToken("x = 'text'", Token(STRING_APHOSTROPHE, "'text'"))

    fun `test identifier`() =
        assertHasToken("var name = 1", Token(IDENTIFIER, "name"))

    fun `test language function`() =
        assertHasToken("x = preload(1)", Token(FUNCTION, "preload"))

    fun `test language constant`() =
        assertHasToken("x = BUTTON_LEFT", Token(CONSTANT, "BUTTON_LEFT"))

    fun `test resource`() =
        assertHasToken("x = \"res://file.gd\"", Token(RESOURCE, "\"res://file.gd\""))

    fun `test user resource`() =
        assertHasToken("x = \"user://save.txt\"", Token(USER_RESOURCE, "\"user://save.txt\""))

    fun `test node`() =
        assertHasToken("\$Some/Node", Token(NODE, "\$Some/Node"))

    private fun assertHasToken(code: String, expectedToken: Token) =
        assertContainsElements(tokenize(ScriptLanguage, ScriptLexer(null), code), expectedToken)

}