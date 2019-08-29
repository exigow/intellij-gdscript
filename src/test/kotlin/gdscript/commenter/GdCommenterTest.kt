package gdscript.commenter

import gdscript.GdBaseTest

class GdCommenterTest : GdBaseTest() {

    fun `test comment`() =
        assertCodeAction("<caret>var x", "#var x")

    fun `test undo comment`() =
        assertCodeAction("<caret>#var x", "var x")

}