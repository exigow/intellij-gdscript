package gdscript.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import uitlities.assertContains
import uitlities.assertNotContains

class DataCompletionContributorTest : BasePlatformTestCase() {

    fun `test sibling files completion`() {
        addFile("project.godot")
        addFile("util.gd")
        addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertContains(lookups(), "res://util.gd")
    }

    fun `test sub directory files completion`() {
        addFile("project.godot")
        addFile("dir/util.gd")
        addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertContains(lookups(), "res://dir/util.gd")
    }

    fun `test do not complete on missing project`() {
        addCode("main.gd", """const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(lookups(), "res://main.gd")
    }

    fun `test hide all dot-prefixed files`() {
        addFile("project.godot")
        addFile("util.gd")
        addFile(".import/file.gd")
        addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(lookups(), "res://.import/file.gd")
        assertContains(lookups(), "res://util.gd")
    }

    fun `test hide "import" extension files`() {
        addFile("project.godot")
        addFile("util.gd")
        addFile("file.import")
        addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(lookups(), "res://file.import")
        assertContains(lookups(), "res://util.gd")
    }

    private fun lookups(): MutableList<String>? =
        myFixture.lookupElementStrings

    private fun addFile(filename: String) =
        myFixture.addFileToProject(filename, "bla bla")

    private fun addCode(content: String) =
        myFixture.configureByText("main.gd", content)

    private fun addCode(filename: String, content: String) =
        myFixture.configureByText(filename, content)


}
