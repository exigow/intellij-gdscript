package script.completion

class ValueCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test self completion`() =
        assertLookupsContains("x = se<caret>", "self")

    fun `test true completion`() =
        assertLookupsContains("x = tr<caret>", "true")

}