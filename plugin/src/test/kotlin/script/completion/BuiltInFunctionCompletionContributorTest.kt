package script.completion

class BuiltInFunctionCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test sin`() =
        assertCompletionEquals("x = si<caret>", "sin")

    fun `test sinh`() =
        assertCompletionEquals("x = si<caret>", "sinh")

    fun `test deg2rad`() =
        assertCompletionEquals("x = deg<caret>", "deg2rad")

    fun `test print`() =
        assertCompletionEquals("pr<caret>", "print")

}