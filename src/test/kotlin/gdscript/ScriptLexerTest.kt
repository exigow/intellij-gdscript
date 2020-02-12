package gdscript

import com.intellij.testFramework.UsefulTestCase.assertContainsElements
import gdscript.ScriptLexer.*
import junit.framework.TestCase
import utils.Token
import utils.tokenize

class ScriptLexerTest : TestCase() {

    fun `test var keyword`() =
        assertHasToken("var x", Token(VAR, "var"))

    fun `test class_name keyword`() =
        assertHasToken("class_name Test", Token(CLASS_NAME, "class_name"))

    fun `test string`() =
        assertHasToken("x = \"text\"", Token(STRING, "\"text\""))

    fun `test string apostrophe`() =
        assertHasToken("x = 'text'", Token(STRING, "'text'"))

    fun `test identifier`() =
        assertHasToken("var name = 1", Token(IDENTIFIER, "name"))

    fun `test language function`() =
        assertHasToken("x = preload(1)", Token(FUNCTION_IDENTIFIER, "preload"))

    fun `test primitive constructor`() =
        assertHasToken("number = float(other)", Token(PRIMITIVE, "float"))

    fun `test number with minus`() =
        assertHasToken("x = -42.0", Token(NUMBER, "-42.0"))

    fun `test primitive void type`() =
        assertHasToken("var x: void", Token(PRIMITIVE, "void"))

    fun `test as operator`() =
        assertHasToken("a as Vector2", Token(CAST_OPERATOR, "as"))

    fun `test in content check operator`() =
        assertHasToken("for x in y:", Token(KEYWORD_OPERATOR, "in"))

    fun `test language constant global`() =
        assertHasToken("x = BUTTON_LEFT", Token(CONSTANT_IDENTIFIER, "BUTTON_LEFT"))

    fun `test resource`() =
        assertHasToken("x = \"res://file.gd\"", Token(RESOURCE, "\"res://file.gd\""))

    fun `test user resource`() =
        assertHasToken("x = \"user://save.txt\"", Token(USER_RESOURCE, "\"user://save.txt\""))

    fun `test node`() =
        assertHasToken("\$Some/Node", Token(NODE, "\$Some/Node"))

    fun `test class as type`() =
        assertHasToken("var position: Vector2", Token(CLASS_IDENTIFIER, "Vector2"))

    fun `test class in extends statement`() =
        assertHasToken("extends Node", Token(CLASS_IDENTIFIER, "Node"))

    fun `test class OS with constant style`() =
        assertHasToken("extends OS", Token(CLASS_IDENTIFIER, "OS"))

    fun `test custom class is identifier`() =
        assertHasToken("var x: MyClass", Token(IDENTIFIER, "MyClass"))

    private fun assertHasToken(code: String, expectedToken: Token) =
        assertContainsElements(tokenize(ScriptLanguage, ScriptLexer(null), code), expectedToken)

}