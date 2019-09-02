package gdscript.completion

import gdscript.GdTestBase

class GdColorCompletionContributorTest : GdTestBase() {

    fun `test color completion`() =
        assertCodeCompletionContains("var color = re$CARET_MARKER", listOf("red"))

}