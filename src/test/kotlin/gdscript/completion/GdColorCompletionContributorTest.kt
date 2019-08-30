package gdscript.completion

import gdscript.GdTestBase

class GdColorCompletionContributorTest : GdTestBase() {

    fun `test color completion`() =
        assertCodeCompletionContains("var color = re<caret>", listOf("red"))

}