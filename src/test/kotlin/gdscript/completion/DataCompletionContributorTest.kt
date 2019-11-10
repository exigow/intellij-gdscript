package gdscript.completion

import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import gdscript.BaseTest
import uitlities.*

class DataCompletionContributorTest : BaseTest() {

    fun `test sibling file completion`() {
        environment.addProjectFile()
        environment.addFile("util.gd")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertContains(environment.lookups(), "res://util.gd")
    }

    fun `test directory completion`() {
        environment.addProjectFile()
        environment.addFile("dir/util.gd")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertContains(environment.lookups(), "res://dir/util.gd")
    }

    fun `test disable completion on missing project file`() {
        environment.addFile("util.gd")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertNotContains(environment.lookups(), "res://util.gd")
    }

    fun `test hide dot-prefixed 'import' file`() {
        environment.addProjectFile()
        environment.addFile("util.gd")
        environment.addFile(".import/file.gd")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertNotContains(environment.lookups(), "res://.import/file.gd")
        assertContains(environment.lookups(), "res://util.gd")
    }

    fun `test hide 'import' extension files`() {
        environment.addProjectFile()
        environment.addFile("util.gd")
        environment.addFile("file.import")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertNotContains(environment.lookups(), "res://file.import")
        assertContains(environment.lookups(), "res://util.gd")
    }

    private fun CodeInsightTestFixture.addProjectFile() =
        addFile("project.godot")

}
