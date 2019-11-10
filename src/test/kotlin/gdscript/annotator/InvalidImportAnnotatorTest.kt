package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class InvalidImportAnnotatorTest : BaseTest() {

    fun `test no warning when file is valid`() {
        environment.addProjectFile()
        environment.addFile("util.gd")
        environment.openCode("""x = preload("res://util.gd")""")
        environment.checkHighlighting()
    }

    fun `test no warning when project file is missing`() {
        environment.addFile("util.gd")
        environment.openCode("""x = preload("res://util.gd")""")
        environment.checkHighlighting()
    }

    fun `test warning on missing file`() {
        environment.addProjectFile()
        environment.addFile("util.gd")
        environment.openCode("""x = preload(<warning descr="Resource 'missing.gd' doesn't exist.">"res://missing.gd"</warning>)""")
        environment.checkHighlighting()
    }

}