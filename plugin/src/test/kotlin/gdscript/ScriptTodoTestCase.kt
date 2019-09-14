package gdscript

import com.intellij.editor.TodoItemsTestCase

class ScriptTodoTestCase : TodoItemsTestCase() {

    override fun supportsCStyleMultiLineComments() = false

    override fun supportsCStyleSingleLineComments() = false

    override fun getFileExtension() = "gd"

    fun `test single line comment todo`() = testTodos("""
        # [TODO: do this]
        var a = 1
        # [TODO: do that]
        var b = 2
    """)

    fun `test multi line block comment todo`() = testTodos(
        "\"\"\"\n" +
        "[TODO: do multiline]\n" +
        "\"\"\"\n")

}