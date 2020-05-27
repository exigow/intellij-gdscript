package gdscript

import gdscript.Colors.*
import junit.framework.TestCase

class ColorsTest : TestCase() {

    fun `test external names to ensure backwards compatibility`() {
        assertEquals(LINE_COMMENT.key.externalName, "GDSCRIPT_LINE_COMMENT")
        assertEquals(IDENTIFIER.key.externalName, "GDSCRIPT_IDENTIFIER")
        assertEquals(STRING.key.externalName, "GDSCRIPT_STRING")
        assertEquals(DOT.key.externalName, "GDSCRIPT_DOT")
    }

    fun `test external names are unique`() {
        val keys = values().map { it.key }
        val actualSize = keys.toList().size
        val uniqueSize = keys.toSet().size
        assertEquals(actualSize, uniqueSize)
    }

}