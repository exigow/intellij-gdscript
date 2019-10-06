package script.completion

class LiteralCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test self completion`() =
        assertCompletionEquals("var current = se<caret>", "self")

}