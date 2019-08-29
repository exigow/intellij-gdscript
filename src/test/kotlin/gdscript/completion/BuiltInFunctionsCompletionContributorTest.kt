package gdscript.completion

import gdscript.BaseTest

class BuiltInFunctionsCompletionContributorTest : BaseTest() {

    fun `test cos`() =
        assertCodeCompletionContains("co<caret>", listOf("cos"))

}