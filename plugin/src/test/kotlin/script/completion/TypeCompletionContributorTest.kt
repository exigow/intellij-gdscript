package script.completion

class TypeCompletionContributorTest : BaseCompletionContributorTest() {

    fun `test var Vector2 type`() =
        assertLookupsContains("var position: Vec<caret>", "Vector2")

    fun `test var float primitive type`() =
        assertLookupsContains("var hp: flo<caret>", "float")

    fun `test var uppercase Float primitive`() =
        assertLookupsContains("var hp: Flo<caret>", "float")

    fun `test extends with Node class`() =
        assertLookupsContains("extends No<caret>", "Node")

    fun `test function return type`() =
        assertLookupsContains("func get_name() -> <caret>", "String")

    fun `test function argument type`() =
        assertLookupsContains("func draw_quad(geometry: <caret>):", "ImmediateGeometry")

}