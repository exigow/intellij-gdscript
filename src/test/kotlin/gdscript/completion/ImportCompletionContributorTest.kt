package gdscript.completion

import gdscript.BaseTest
import uitlities.*

class ImportCompletionContributorTest : BaseTest() {

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

    fun `test hide dot-'import' directory`() {
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

    fun `test hide all dot-prefixed directories and files`() {
        environment.addProjectFile()
        environment.addFile(".git/objects/f8/0ad0ab9163ad8ac5c83e5c5de7d309b146c59a")
        environment.addFile(".gitignore")
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

}
