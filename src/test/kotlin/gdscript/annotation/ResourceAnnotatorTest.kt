package gdscript.annotation

import BaseTest
import com.intellij.lang.annotation.HighlightSeverity.WEAK_WARNING
import utils.addProjectFile
import utils.openScript

class ResourceAnnotatorTest : BaseTest() {

    fun `test warning on missing file`() {
        environment.openScript("x = 'res://missing.gd'")
        environment.addProjectFile()
        val warning = environment.doHighlighting().first()
        assertEquals(warning.text, "'res://missing.gd'")
        assertEquals(warning.severity, WEAK_WARNING)
        assertEquals(warning.description, "Cannot resolve resource 'missing.gd'")
    }

    fun `test warning on missing file double quote variant`() {
        environment.openScript("x = \"res://missing.gd\"")
        environment.addProjectFile()
        val warning = environment.doHighlighting().first()
        assertEquals(warning.text, "\"res://missing.gd\"")
        assertEquals(warning.severity, WEAK_WARNING)
        assertEquals(warning.description, "Cannot resolve resource 'missing.gd'")
    }

    fun `test ignore on missing project`() {
        environment.openScript("x = 'res://missing.gd'")
        assertEmpty(environment.doHighlighting())
    }

    fun `test ignore user file`() {
        environment.openScript("x = 'user://save.txt'")
        environment.addProjectFile()
        assertEmpty(environment.doHighlighting())
    }

}
