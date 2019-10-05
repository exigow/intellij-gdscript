package script.completion

class KeywordCompletionTest : CompletionTest() {

    fun `test export`() =
        assertCompletionEquals("ex<caret>", "export")

    fun `test extends`() =
        assertCompletionEquals("ex<caret>", "extends")

    fun `test const`() =
        assertCompletionEquals("co<caret>", "const")

}