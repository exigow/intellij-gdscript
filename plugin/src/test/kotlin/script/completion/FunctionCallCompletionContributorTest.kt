package script.completion

class FunctionCallCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test function as statement`() =
        assertCompletionEquals("pr<caret>", "print")

    fun `test edit existing function`() =
        assertCompletionEquals("x = si<caret>()", "sin")

    fun `test function in var statement`() =
        assertCompletionEquals("var x = si<caret>", "sin")

    fun `test function in dictionary`() =
        assertCompletionEquals("dict = {A = 1, B = si<caret>}", "sin")

}