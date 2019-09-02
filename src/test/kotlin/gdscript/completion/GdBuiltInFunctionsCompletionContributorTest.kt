package gdscript.completion

import gdscript.GdTestBase

class GdBuiltInFunctionsCompletionContributorTest : GdTestBase() {

    fun `test cos`() =
        assertCodeCompletionContains("co$CARET_MARKER", listOf("cos"))

}