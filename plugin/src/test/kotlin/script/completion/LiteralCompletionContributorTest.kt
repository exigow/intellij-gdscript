package script.completion

class LiteralCompletionContributorTest : CompletionContributorTest() {

    fun `test self completion`() =
        assertCompletionEquals("var current = se<caret>", "self")

}