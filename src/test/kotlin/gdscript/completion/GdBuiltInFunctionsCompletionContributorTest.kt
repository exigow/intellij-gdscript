package gdscript.completion

import gdscript.GdTestBase

class GdBuiltInFunctionsCompletionContributorTest : GdTestBase() {

    fun `test cos`() =
        assertCodeCompletionContains("co<caret>", listOf("cos"))

}