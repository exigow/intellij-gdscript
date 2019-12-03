package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class InvalidImportAnnotatorTest : BaseTest() {

    fun `test warning on missing file`() {
        environment.openCode("""x = preload("res://missing.gd")""")
        environment.addProjectFile()
        assertTrue("\"res://missing.gd\"" in environment.highlightedTexts())
        assertTrue("Cannot resolve resource 'missing.gd'" in environment.highlightedDescriptions())
    }

    fun `test no warning when file is valid`() {
        environment.openCode("""x = preload("res://util.gd")""")
        environment.addFile("util.gd")
        environment.addProjectFile()
        assertEmpty(environment.highlightedTexts())
    }

    fun `test no warning when project file is missing`() {
        environment.openCode("""x = preload("res://util.gd")""")
        environment.addFile("util.gd")
        assertEmpty(environment.highlightedTexts())
    }

}