package gdscript.completion

import gdscript.BaseTest

class ColorCompletionContributorTest : BaseTest() {

    fun `test color completion`() =
        assertCompletionContains("var color = re<caret>", "red")

}