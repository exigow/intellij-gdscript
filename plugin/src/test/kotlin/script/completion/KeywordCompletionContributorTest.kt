package script.completion

class KeywordCompletionContributorTest : CompletionContributorTest() {

    fun `test export`() =
        assertCompletionEquals("ex<caret>", "export")

    fun `test extends`() =
        assertCompletionEquals("ex<caret>", "extends")

    fun `test const`() =
        assertCompletionEquals("co<caret>", "const")

}