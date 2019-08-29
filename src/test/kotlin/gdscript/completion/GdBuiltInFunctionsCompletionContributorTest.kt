package gdscript.completion

import gdscript.GdBaseTest

class GdBuiltInFunctionsCompletionContributorTest : GdBaseTest() {

    fun `test cos`() =
        assertCompletionContains("co<caret>", "cos")

}