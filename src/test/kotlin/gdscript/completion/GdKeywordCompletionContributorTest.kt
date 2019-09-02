package gdscript.completion

import gdscript.GdTestBase

class GdKeywordCompletionContributorTest : GdTestBase() {

    fun `test keyword var`() =
        assertCodeCompletionContains("va$CARET_MARKER", listOf("var"))

    fun `test keyword validate_json function`() =
        assertCodeCompletionContains("va$CARET_MARKER", listOf("validate_json"))

    fun `test keyword const`() =
        assertCodeCompletionContains("co$CARET_MARKER", listOf("const"))

}