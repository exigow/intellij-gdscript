package gdscript.commenter

import gdscript.BaseTest

class CommenterTest : BaseTest() {

    fun `test comment`() =
        assertCodeAction("<caret>var x", "#var x")

    fun `test undo comment`() =
        assertCodeAction("<caret>#var x", "var x")

}