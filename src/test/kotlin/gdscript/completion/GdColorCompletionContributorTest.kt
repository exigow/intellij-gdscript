package gdscript.completion

import gdscript.GdBaseTest

class GdColorCompletionContributorTest : GdBaseTest() {

    fun `test color completion`() =
        assertCompletionContains("var color = re<caret>", "red")

}