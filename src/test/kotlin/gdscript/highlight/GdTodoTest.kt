package gdscript.highlight

import com.intellij.editor.TodoItemsTestCase
import gdscript.GdFileType

class GdTodoTest : TodoItemsTestCase() {

    override fun supportsCStyleMultiLineComments() = false

    override fun supportsCStyleSingleLineComments() = false

    override fun getFileExtension() = GdFileType.defaultExtension

    fun `test single line comment todo`() = testTodos("""
        # ${START_MARKER}TODO: do this$END_MARKER
        var a = 1
        # ${START_MARKER}TODO: do that$END_MARKER
        var b = 2
    """)

    fun `test multi line block comment todo`() = testTodos(
        "\"\"\"\n" +
        "${START_MARKER}TODO: do multiline$END_MARKER\n" +
        "\"\"\"\n")

    private companion object {

        private const val START_MARKER = "["
        private const val END_MARKER = "]"

    }

}