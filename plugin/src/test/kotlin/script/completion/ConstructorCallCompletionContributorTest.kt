package script.completion

class ConstructorCallCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test Vector2 constructor`() =
        assertLookupsContains("position = Vec<caret>", "Vector2")

    fun `test primitive float constructor`() =
        assertLookupsContains("x = flo<caret>", "float")

    fun `test edit existing constructor`() =
        assertLookupsContains("position = Vec<caret>()", "Vector2")

    fun `test constructor call is case-sensitive`() =
        assertLookupsNotContains("position = vec<caret>()", "Vector2")

}