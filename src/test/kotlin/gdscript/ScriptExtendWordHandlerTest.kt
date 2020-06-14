package gdscript

import BaseTest
import com.intellij.openapi.actionSystem.IdeActions.ACTION_EDITOR_SELECT_WORD_AT_CARET
import utils.openScript

class ScriptExtendWordHandlerTest : BaseTest() {

    fun `test select string content then extend to quotes`() {
        environment.openScript("text = \"ab<caret>c\"")
        doExtendWordAction()
        assertSelectionEquals("abc")
        doExtendWordAction()
        assertSelectionEquals("\"abc\"")
    }

    fun `test select if expression then whole statement`() {
        environment.openScript("if <caret>size > 1:")
        doExtendWordAction()
        assertSelectionEquals("size")
        doExtendWordAction()
        assertSelectionEquals("size > 1")
        doExtendWordAction()
        assertSelectionEquals("if size > 1:")
    }

    fun `test select whole arrow operator`() {
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

    private fun doExtendWordAction() =
        environment.performEditorAction(ACTION_EDITOR_SELECT_WORD_AT_CARET)

    private fun assertSelectionEquals(tested: String) =
        assertEquals(tested, environment.editor.selectionModel.selectedText)

}
