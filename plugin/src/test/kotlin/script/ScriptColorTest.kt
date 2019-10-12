package script

import junit.framework.TestCase

class ScriptColorTest : TestCase() {

    fun `test GODOT_SCRIPT_LINE_COMMENT external name`() {
        assertEquals(ScriptColor.LINE_COMMENT.key.externalName, "GODOT_SCRIPT_LINE_COMMENT")
    }
}