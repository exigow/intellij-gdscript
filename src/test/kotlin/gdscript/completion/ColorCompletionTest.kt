package gdscript.completion

import gdscript.BaseTest

class ColorCompletionTest : BaseTest() {

    fun `test color completion`() =
        assertCompletionContains("var color = re<caret>", "red")

}