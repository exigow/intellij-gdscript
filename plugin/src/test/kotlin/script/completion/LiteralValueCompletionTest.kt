package script.completion

class LiteralValueCompletionTest : CompletionTest() {

    fun `test self completion`() =
        assertCompletionEquals("var current = se<caret>", "self")

}