package gdscript.completion

import gdscript.BaseTest
import uitlities.openCode
import uitlities.addFile
import uitlities.assertContains
import uitlities.assertNotContains

class DataCompletionContributorTest : BaseTest() {

    fun `test sibling files completion`() {
        environment.addFile("project.godot")
        environment.addFile("util.gd")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertContains(lookups(), "res://util.gd")
    }

    fun `test sub directory files completion`() {
        environment.addFile("project.godot")
        environment.addFile("dir/util.gd")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertContains(lookups(), "res://dir/util.gd")
    }

    fun `test do not complete on missing project`() {
        environment.openCode("main.gd", """const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertNotContains(lookups(), "res://main.gd")
    }

    fun `test hide all dot-prefixed files`() {
        environment.addFile("project.godot")
        environment.addFile("util.gd")
        environment.addFile(".import/file.gd")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertNotContains(lookups(), "res://.import/file.gd")
        assertContains(lookups(), "res://util.gd")
    }

    fun `test hide "import" extension files`() {
        environment.addFile("project.godot")
        environment.addFile("util.gd")
        environment.addFile("file.import")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertNotContains(lookups(), "res://file.import")
        assertContains(lookups(), "res://util.gd")
    }

    private fun lookups(): MutableList<String>? =
        environment.lookupElementStrings

}
