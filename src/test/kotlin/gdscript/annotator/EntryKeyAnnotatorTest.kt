package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class EntryKeyAnnotatorTest : BaseTest() {

    fun `test highlight Lua-style entry key name`() {
        environment.openScript("dict = {key = value}")
        assertContainsElements(environment.highlights(), "key")
    }

    fun `test highlight String entry key name`() {
        environment.openScript("""dict = {"key" = value}""")
        assertContainsElements(environment.highlights(), "\"key\"")
    }

}