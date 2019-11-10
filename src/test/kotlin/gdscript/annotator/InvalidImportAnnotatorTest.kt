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
        environment.openCode("""x = preload(<weak_warning descr="Cannot resolve resource 'missing.gd'">"res://missing.gd"</weak_warning>)""")
        environment.checkHighlighting()
    }

}