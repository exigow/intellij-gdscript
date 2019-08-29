package gdscript.commenter

import gdscript.BaseTest

class CommenterTest : BaseTest() {

    fun `test comment`() =
        assertCodeChangesAfterAction("<caret>var x", "#var x")

    fun `test undo comment`() =
        assertCodeChangesAfterAction("<caret>#var x", "var x")

}