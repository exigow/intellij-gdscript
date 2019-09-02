package gdscript.highlight

import com.intellij.editor.TodoItemsTestCase
import gdscript.GdFileType

class GdTodoTest : TodoItemsTestCase() {

    override fun supportsCStyleMultiLineComments() = false

    override fun supportsCStyleSingleLineComments() = false

    override fun getFileExtension() = GdFileType.defaultExtension

    fun `test single line comment todo`() = testTodos("""
        # [todo first line]
        var a = 1
        # [todo second line line]
        var b = 2
    """)

    fun `test multi line block comment todo`() = testTodos(
        "\"\"\"\n" +
        "[todo test]\n" +
        "\"\"\"\n")

}