package gdscript.options

import junit.framework.TestCase

class ColorTextAttributeKeyTest : TestCase() {

    fun `test external name to ensure backwards compatibility`() {
        assertEquals(ColorTextAttributeKey.LINE_COMMENT.key.externalName, "GDSCRIPT_LINE_COMMENT")
    }

}