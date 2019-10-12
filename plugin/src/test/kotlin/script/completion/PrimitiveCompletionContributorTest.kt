package script.completion

class PrimitiveCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test variable definition type`() =
        assertLookupsContains("var hp: flo<caret>", "float")

    fun `test recognize object-like Float with upper case character as float primitive type`() =
        assertLookupsContains("var hp: Flo<caret>", "float")

    fun `test extends primitive type`() =
        assertLookupsContains("extends fl<caret>", "float")

    fun `test function return type`() =
        assertLookupsContains("func get() -> in<caret>:", "int")

}