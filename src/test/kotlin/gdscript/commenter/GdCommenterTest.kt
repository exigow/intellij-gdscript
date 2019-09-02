package gdscript.commenter

import gdscript.GdTestBase

class GdCommenterTest : GdTestBase() {

    fun `test comment`() =
        assertCodeChangesAfterAction("${CARET_MARKER}var x", "#var x")

    fun `test undo comment`() =
        assertCodeChangesAfterAction("$CARET_MARKER#var x", "var x")

}