package gdscript.completion

import gdscript.BaseTest

class BuiltInFunctionsCompletionContributorTest : BaseTest() {

    fun `test cos`() =
        assertCompletionContains("co<caret>", "cos")

}