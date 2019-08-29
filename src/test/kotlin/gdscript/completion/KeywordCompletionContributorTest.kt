package gdscript.completion

import gdscript.BaseTest

class KeywordCompletionContributorTest : BaseTest() {

    fun `test keyword var`() =
        assertCodeCompletionContains("va<caret>", listOf("var"))

    fun `test keyword validate_json function`() =
        assertCodeCompletionContains("va<caret>", listOf("validate_json"))

    fun `test keyword const`() =
        assertCodeCompletionContains("co<caret>", listOf("const"))

    fun `test keyword continue`() =
        assertCodeCompletionContains("cont<caret>", listOf("continue"))

}