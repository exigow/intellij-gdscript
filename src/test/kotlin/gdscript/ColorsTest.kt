package gdscript

import gdscript.Colors.*
import junit.framework.TestCase

class ColorsTest : TestCase() {

    fun `test keys are not changing`() {
        assertEquals(LINE_COMMENT.key.externalName, "GDSCRIPT_LINE_COMMENT")
        assertEquals(IDENTIFIER.key.externalName, "GDSCRIPT_IDENTIFIER")
        assertEquals(STRING.key.externalName, "GDSCRIPT_STRING")
        assertEquals(DOT.key.externalName, "GDSCRIPT_DOT")
    }

    fun `test keys are unique`() {
        val keys = values().map { it.key }
        val list = keys.toList().size
        val set = keys.toSet().size
        assertEquals(list, set)
    }

}