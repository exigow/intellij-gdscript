package script.completion

class ClassNameCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test variable definition Vector2 type`() =
        assertLookupsContains("var position: Vec<caret>", "Vector2")

    fun `test accept lower case`() =
        assertLookupsContains("var position: vec<caret>", "Vector2")

    fun `test extends with Node class`() =
        assertLookupsContains("extends No<caret>", "Node")

    fun `test function return type`() =
        assertLookupsContains("func get_name() -> <caret>", "String")

    fun `test function argument type`() =
        assertLookupsContains("func draw_quad(geometry: <caret>):", "ImmediateGeometry")

}