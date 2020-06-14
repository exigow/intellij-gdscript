package gdscript.lexer

import com.intellij.psi.tree.IElementType
import com.intellij.testFramework.LexerTestCase
import gdscript.ScriptTokenType.CLASS_NAME
import gdscript.ScriptTokenType.CONSTANT
import gdscript.ScriptTokenType.DOUBLE_QUOTED_STRING
import gdscript.ScriptTokenType.IDENTIFIER
import gdscript.ScriptTokenType.KEYWORD
import gdscript.ScriptTokenType.NODE
import gdscript.ScriptTokenType.NUMBER
import gdscript.ScriptTokenType.SINGLE_QUOTED_STRING
import gdscript.ScriptTokenType.UNRECOGNIZED
import junit.framework.TestCase

class ScriptLexerTest : TestCase() {

    fun `test unrecognized character`( ) =
        assertHasToken("???", UNRECOGNIZED, "?")

    fun `test "var" keyword`() =
        assertHasToken("var x", KEYWORD, "var")

    fun `test variable when name prefix is also "in" keyword operator`() =
        assertHasToken("index", IDENTIFIER, "index")

    fun `test custom type when name prefix is also "Vector3" class name`() =
        assertHasToken("Vector3Better", IDENTIFIER, "Vector3Better")

    fun `test "class_name" keyword`() =
        assertHasToken("class_name Test", KEYWORD, "class_name")

    fun `test string`() =
        assertHasToken("x = \"text\"", DOUBLE_QUOTED_STRING, "\"text\"")

    fun `test string apostrophe`() =
        assertHasToken("x = 'text'", SINGLE_QUOTED_STRING, "'text'")

    fun `test identifier`() =
        assertHasToken("var name", IDENTIFIER, "name")

    fun `test language-level function`() =
        assertHasToken("x = preload()", KEYWORD, "preload")

    fun `test primitive constructor`() =
        assertHasToken("number = float(other)", KEYWORD, "float")

    fun `test number`() =
        assertHasToken("x = 42.0", NUMBER, "42.0")

    fun `test scientific number`() =
        assertHasToken("x = 123.01e-12", NUMBER, "123.01e-12")

    fun `test primitive "void" type`() =
        assertHasToken("var x: void", KEYWORD, "void")

    fun `test "as" operator`() =
        assertHasToken("a as Vector2", KEYWORD, "as")

    fun `test "in" content check operator`() =
        assertHasToken("for x in y:", KEYWORD, "in")

    fun `test language-level constant`() =
        assertHasToken("x = BUTTON_LEFT", CONSTANT, "BUTTON_LEFT")

    fun `test resource`() =
        assertHasToken("x = \"res://file.gd\"", DOUBLE_QUOTED_STRING, "\"res://file.gd\"")

    fun `test user resource`() =
        assertHasToken("x = \"user://save.txt\"", DOUBLE_QUOTED_STRING, "\"user://save.txt\"")

    fun `test node`() =
        assertHasToken("\$Some/Node", NODE, "\$Some/Node")

    fun `test class as type`() =
        assertHasToken("var position: Vector2", CLASS_NAME, "Vector2")

    fun `test class in "extends" statement`() =
        assertHasToken("extends Node", CLASS_NAME, "Node")

    fun `test class "OS" similar to constant`() =
        assertHasToken("extends OS", CLASS_NAME, "OS")

    fun `test custom class is identifier`() =
        assertHasToken("var x: MyClass", IDENTIFIER, "MyClass")

    private fun assertHasToken(code: String, expectedToken: IElementType, expectedTokenText: String) {
        println(LexerTestCase.printTokens(code, 0, ScriptLexer()))
        val lexer = ScriptLexer()
        lexer.start(code, 0, code.length)
        var currentToken: IElementType?
        while (lexer.tokenType.also { currentToken = it } != null) {
            if (currentToken == expectedToken && lexer.tokenText == expectedTokenText)
                return
            lexer.advance()
        }
        fail("Token $expectedToken not found")
    }

}
