package gdscript.completion

import gdscript.BaseTest
import uitlities.*

class ImportCompletionContributorTest : BaseTest() {

    fun `test sibling file completion`() {
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.addFile("util.gd")
        environment.addProjectFile()
        assertTrue("res://util.gd" in environment.lookupTexts())
    }

    fun `test directory completion`() {
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.addFile("dir/util.gd")
        environment.addProjectFile()
        assertTrue("res://dir/util.gd" in environment.lookupTexts())
    }

    fun `test disable completion on missing project file`() {
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.addFile("util.gd")
        assertFalse("res://util.gd" in environment.lookupTexts())
    }

    fun `test hide 'import' directory`() {
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.addFile(".import/file.gd")
        environment.addProjectFile()
        assertEmpty(environment.lookupTexts())
    }

    fun `test hide 'import' file`() {
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.addFile("file.import")
        environment.addProjectFile()
        assertEmpty(environment.lookupTexts())
    }

    fun `test hide dot-prefixed file`() {
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.addFile(".gitignore")
        environment.addProjectFile()
        assertEmpty(environment.lookupTexts())
    }

    fun `test hide dot-prefixed directory`() {
        environment.openCode("""const Util = preload("res://<caret>")""")
        environment.addFile(".git/objects/f8/0ad0ab9163ad8ac5c83e5c5de7d309b146c59a")
        environment.addProjectFile()
        assertEmpty(environment.lookupTexts())
    }

}
