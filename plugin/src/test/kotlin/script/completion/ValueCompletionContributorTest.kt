package script.completion

class ValueCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test self completion`() =
        assertCompletionEquals("x = se<caret>", "self")

    fun `test true completion`() =
        assertCompletionEquals("x = tr<caret>", "true")

}