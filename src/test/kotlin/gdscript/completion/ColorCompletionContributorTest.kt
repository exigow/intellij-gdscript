package gdscript.completion

import gdscript.BaseTest

class ColorCompletionContributorTest : BaseTest() {

    fun `test color completion`() =
        assertCodeCompletionContains("var color = re<caret>", listOf("red"))

}