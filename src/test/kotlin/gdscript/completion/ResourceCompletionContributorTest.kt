package gdscript.completion

import BaseTest
import utils.addFile
import utils.addProjectFile
import utils.lookups
import utils.openScript

class ResourceCompletionContributorTest : BaseTest() {

    fun `test complete sibling filename in double quote string`() {
        environment.openScript("""const Util = preload("res://<caret>")""")
        environment.addFile("util.gd")
        environment.addProjectFile()
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "res://util.gd")
    }

    fun `test complete sibling filename in single quote string`() {
        environment.openScript("""const Util = preload('res://<caret>')""")
        environment.addFile("util.gd")
        environment.addProjectFile()
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "res://util.gd")
    }

    fun `test complete directory in string`() {
        environment.openScript("""const Util = preload("res://<caret>")""")
        environment.addFile("dir/util.gd")
        environment.addProjectFile()
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "res://dir/util.gd")
    }

    fun `test don't complete project file is missing`() {
        environment.openScript("""const Util = preload("res://<caret>")""")
        environment.addFile("util.gd")
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

    fun `test don't complete "import" directory`() {
        environment.openScript("""const Util = preload("res://<caret>")""")
        environment.addFile(".import/file.gd")
        environment.addProjectFile()
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

    fun `test don't complete "import" file`() {
        environment.openScript("""const Util = preload("res://<caret>")""")
        environment.addFile("file.import")
        environment.addProjectFile()
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

    fun `test don't complete file with dot-prefixed name`() {
        environment.openScript("""const Util = preload("res://<caret>")""")
        environment.addFile(".gitignore")
        environment.addProjectFile()
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

    fun `test don't complete file in dot-prefixed directory`() {
        environment.openScript("""const Util = preload("res://<caret>")""")
        environment.addFile(".git/objects/f8/0ad0ab9163ad8ac5c83e5c5de7d309b146c59a")
        environment.addProjectFile()
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

}
