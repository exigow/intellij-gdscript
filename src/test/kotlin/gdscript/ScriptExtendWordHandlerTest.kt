package gdscript

import BaseTest
import com.intellij.openapi.actionSystem.IdeActions.ACTION_EDITOR_SELECT_WORD_AT_CARET
import utils.openScript

class ScriptExtendWordHandlerTest : BaseTest() {

    fun `test extend resource path`() {
        environment.openScript("""x = "res://dir/abc<caret>.gd"""")
        doExtendWordAction()
        assertSelectionEquals("abc")
        doExtendWordAction()
        assertSelectionEquals("dir/abc.gd")
        doExtendWordAction()
        assertSelectionEquals("\"res://dir/abc.gd\"")
    }

    fun `test extend string content to string double quotes`() {
        environment.openScript("x = \"<selection>abc<caret></selection>\"")
        doExtendWordAction()
        assertSelectionEquals("\"abc\"")
    }

    fun `test extend string content to string single quotes`() {
        environment.openScript("x = '<selection>abc<caret></selection>'")
        doExtendWordAction()
        assertSelectionEquals("'abc'")
    }

    fun `test extend selection to 'if' condition body`() {
        environment.openScript("if <selection>size<caret></selection> > 1:")
        doExtendWordAction()
        assertSelectionEquals("size > 1")
    }

    fun `test extend caret after arrow to whole arrow symbol`() {
        environment.openScript("fun x() -><caret> bool:")
        doExtendWordAction()
        assertSelectionEquals("->")
    }

    fun `test select function arguments then whole statement`() {
        environment.openScript("func f(x<caret>: float = 0):")
        doExtendWordAction()
        assertSelectionEquals("x")
        doExtendWordAction()
        assertSelectionEquals("x: float = 0")
        doExtendWordAction()
        assertSelectionEquals("(x: float = 0)")
        doExtendWordAction()
        assertSelectionEquals("func f(x: float = 0):")
    }

    fun `test select array in dictionary`() {
        environment.openScript("a = {b = [c<caret>]}")
        doExtendWordAction()
        assertSelectionEquals("c")
        doExtendWordAction()
        assertSelectionEquals("[c]")
        doExtendWordAction()
        assertSelectionEquals("b = [c]")
        doExtendWordAction()
        assertSelectionEquals("{b = [c]}")
        doExtendWordAction()
        assertSelectionEquals("a = {b = [c]}")
    }

    fun `test select function invocation`() {
        environment.openScript("foo<caret>()")
        doExtendWordAction()
        assertSelectionEquals("foo")
        doExtendWordAction()
        assertSelectionEquals("foo()")
    }

    fun `test select extended class then whole statement`() {
        environment.openScript("extends Node<caret>")
        doExtendWordAction()
        assertSelectionEquals("Node")
        doExtendWordAction()
        assertSelectionEquals("extends Node")
    }

    fun `test var from left to right when surrounded by other statements`() {
        environment.openScript("""
            var x = 1
            <caret>var y = 2
            var z = 3
        """.trimIndent())
        doExtendWordAction()
        assertSelectionEquals("var")
        doExtendWordAction()
        assertSelectionEquals("var y = 2")
    }

    fun `test var value expression`() {
        environment.openScript("var x: int = 1 + 2<caret> + 3")
        doExtendWordAction()
        assertSelectionEquals("2")
        doExtendWordAction()
        assertSelectionEquals("1 + 2 + 3")
    }

    fun `test return expression`() {
        environment.openScript("return 1<caret> + 2")
        doExtendWordAction()
        assertSelectionEquals("1")
        doExtendWordAction()
        assertSelectionEquals("1 + 2")
    }

    private fun doExtendWordAction() =
        environment.performEditorAction(ACTION_EDITOR_SELECT_WORD_AT_CARET)

    private fun assertSelectionEquals(tested: String) =
        assertEquals(tested, environment.editor.selectionModel.selectedText)

}
