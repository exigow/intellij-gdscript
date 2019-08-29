package gdscript.completion

import gdscript.BaseTest

class KeywordCompletionContributorTest : BaseTest() {

    fun `test keyword var`() =
        assertCompletionContains("va<caret>", "var")

    fun `test keyword const`() =
        assertCompletionContains("co<caret>", "const")

}