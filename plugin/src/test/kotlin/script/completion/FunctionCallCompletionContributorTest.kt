package script.completion

class FunctionCallCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test function as statement`() =
        assertLookupsContains("pr<caret>", "print")

    fun `test edit existing function`() =
        assertLookupsContains("x = si<caret>()", "sin")

    fun `test function in var statement`() =
        assertLookupsContains("var x = si<caret>", "sin")

    fun `test function in dictionary`() =
        assertLookupsContains("dict = {A = 1, B = si<caret>}", "sin")

    fun `test function is case-sensitive`() =
        assertLookupsNotContains("x = Si<caret>()", "sin")

}