package gdscript.completion

import gdscript.GdBaseTest

class GdKeywordCompletionContributorTest : GdBaseTest() {

    fun `test keyword var`() =
        assertCompletionContains("va<caret>", "var")

    fun `test keyword const`() =
        assertCompletionContains("co<caret>", "const")

}