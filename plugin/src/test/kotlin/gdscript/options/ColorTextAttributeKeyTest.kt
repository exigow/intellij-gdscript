package gdscript.options

import gdscript.options.ColorTextAttributeKey.*
import junit.framework.TestCase

class ColorTextAttributeKeyTest : TestCase() {

    fun `test external name to ensure backwards compatibility`() {
        assertEquals(LINE_COMMENT.key.externalName, "GDSCRIPT_LINE_COMMENT")
        assertEquals(IDENTIFIER.key.externalName, "GDSCRIPT_IDENTIFIER")
        assertEquals(STRING.key.externalName, "GDSCRIPT_STRING")
        assertEquals(DOT.key.externalName, "GDSCRIPT_DOT")
    }

}