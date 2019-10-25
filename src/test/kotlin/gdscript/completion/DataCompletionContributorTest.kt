package gdscript.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import uitlities.addCode
import uitlities.addFile
import uitlities.assertContains
import uitlities.assertNotContains

class DataCompletionContributorTest : BasePlatformTestCase() {

    fun `test sibling files completion`() {
        myFixture.addFile("project.godot")
        myFixture.addFile("util.gd")
        myFixture.addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertContains(lookups(), "res://util.gd")
    }

    fun `test sub directory files completion`() {
        myFixture.addFile("project.godot")
        myFixture.addFile("dir/util.gd")
        myFixture.addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertContains(lookups(), "res://dir/util.gd")
    }

    fun `test do not complete on missing project`() {
        myFixture.addCode("main.gd", """const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(lookups(), "res://main.gd")
    }

    fun `test hide all dot-prefixed files`() {
        myFixture.addFile("project.godot")
        myFixture.addFile("util.gd")
        myFixture.addFile(".import/file.gd")
        myFixture.addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(lookups(), "res://.import/file.gd")
        assertContains(lookups(), "res://util.gd")
    }

    fun `test hide "import" extension files`() {
        myFixture.addFile("project.godot")
        myFixture.addFile("util.gd")
        myFixture.addFile("file.import")
        myFixture.addCode("""const Util = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(lookups(), "res://file.import")
        assertContains(lookups(), "res://util.gd")
    }

    private fun lookups(): MutableList<String>? =
        myFixture.lookupElementStrings

}
