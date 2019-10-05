package script.completion

class TypeCompletionTest : CompletionTest() {

    fun `test var Vector2 type`() =
        assertCompletionEquals("var position: Vec<caret>", "Vector2")

    fun `test var float primitive type`() =
        assertCompletionEquals("var hp: flo<caret>", "float")

    fun `test var uppercase Float primitive`() =
        assertCompletionEquals("var hp: Flo<caret>", "float")

    fun `test extends with Node class`() =
        assertCompletionEquals("extends No<caret>", "Node")

    fun `test function return type`() =
        assertCompletionEquals("func get_name() -> <caret>", "String")

    fun `test function argument type`() =
        assertCompletionEquals("func draw_quad(geometry: <caret>):", "ImmediateGeometry")

}