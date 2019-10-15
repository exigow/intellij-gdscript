package gdscript.options

import junit.framework.TestCase

class ColorTextAttributeKeyTest : TestCase() {

    fun `test GODOT_SCRIPT_LINE_COMMENT external name`() {
        assertEquals(ColorTextAttributeKey.LINE_COMMENT.key.externalName, "GODOT_SCRIPT_LINE_COMMENT")
    }
}