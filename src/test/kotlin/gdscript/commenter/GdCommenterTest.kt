package gdscript.commenter

import gdscript.GdTestBase

class GdCommenterTest : GdTestBase() {

    fun `test comment`() =
        assertCodeChangesAfterAction("<caret>var x", "#var x")

    fun `test undo comment`() =
        assertCodeChangesAfterAction("<caret>#var x", "var x")

}