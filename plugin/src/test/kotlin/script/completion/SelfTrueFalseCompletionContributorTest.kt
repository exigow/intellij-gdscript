package script.completion

class SelfTrueFalseCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test self completion`() =
        assertLookupsContains("x = se<caret>", "self")

    fun `test true completion`() =
        assertLookupsContains("x = tr<caret>", "true")

    fun `test false completion`() =
        assertLookupsContains("x = fa<caret>", "false")


}