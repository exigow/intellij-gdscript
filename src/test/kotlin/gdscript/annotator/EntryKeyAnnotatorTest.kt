package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class EntryKeyAnnotatorTest : BaseTest() {

    fun `test Lua-style entry`() {
        environment.openCode("dict = {key = value}")
        assertTrue("key" in environment.highlightedTexts())
    }

    fun `test String entry`() {
        environment.openCode("""dict = {"key" = value}""")
        assertTrue("\"key\"" in environment.highlightedTexts())
    }

}