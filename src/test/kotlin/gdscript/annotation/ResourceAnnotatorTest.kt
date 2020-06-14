package gdscript.annotation

import BaseTest
import com.intellij.lang.annotation.HighlightSeverity.INFORMATION
import com.intellij.lang.annotation.HighlightSeverity.WEAK_WARNING
import utils.addFile
import utils.addProjectFile
import utils.highlights
import utils.openScript

class ResourceAnnotatorTest : BaseTest() {

    fun `test warning when file is missing`() {
        environment.openScript("""x = preload("res://missing.gd")""")
        environment.addProjectFile()
        val warning = environment.doHighlighting().first()
        assertEquals(warning.text, "\"res://missing.gd\"")
        assertEquals(warning.severity, WEAK_WARNING)
        assertEquals(warning.description, "Cannot resolve resource 'missing.gd'")
    }

    fun `test no warning when when project root is missing`() {
        environment.openScript("""x = preload("res://missing.gd")""")
        assertEmpty(environment.doHighlighting())
    }

    fun `test green when file exists`() {
        environment.openScript("""x = preload("res://util.gd")""")
        environment.addFile("util.gd")
        environment.addProjectFile()
        val info = environment.doHighlighting().first()
        assertEquals("\"res://util.gd\"", info.text)
        assertEquals(INFORMATION, info.severity)
    }

    fun `test ignore user resources`() {
        environment.openScript("""x = "user://save.txt"""")
        environment.addProjectFile()
        assertEmpty(environment.highlights())
    }

    fun `test single quote string is ok`() {
        environment.openScript("""x = preload('res://util.gd')""")
        environment.addFile("util.gd")
        environment.addProjectFile()
        val info = environment.doHighlighting().first()
        assertEquals("'res://util.gd'", info.text)
        assertEquals(INFORMATION, info.severity)
    }

}