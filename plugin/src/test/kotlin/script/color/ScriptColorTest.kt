package script.color

import junit.framework.TestCase
import script.colors.ScriptColor

class ScriptColorTest : TestCase() {

    fun `test expected LINE_COMMENT external name`() {
        assertEquals(ScriptColor.LINE_COMMENT.key.externalName, "GODOT_SCRIPT_LINE_COMMENT")
    }
}