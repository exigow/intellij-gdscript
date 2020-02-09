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
        assertHasToken("x = \"text\"", Token(STRING_DOUBLE_QUOTE, "\"text\""))

    fun `test string apostrophe`() =
        assertHasToken("x = 'text'", Token(STRING_APHOSTROPHE, "'text'"))

    fun `test identifier`() =
        assertHasToken("var name = 1", Token(IDENTIFIER, "name"))

    fun `test language function`() =
        assertHasToken("x = preload(1)", Token(FUNCTION_IDENTIFIER, "preload"))

    fun `test primitive constructor`() =
        assertHasToken("number = float(other)", Token(BOOL_INT_FLOAT_VOID, "float"))

    fun `test number with minus`() =
        assertHasToken("x = -42.0", Token(NUMBER, "-42.0"))

    fun `test primitive void type`() =
        assertHasToken("var x: void", Token(BOOL_INT_FLOAT_VOID, "void"))

    fun `test is operator`() =
        assertHasToken("a is b", Token(IS_AS_IN_AND_OR, "is"))

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