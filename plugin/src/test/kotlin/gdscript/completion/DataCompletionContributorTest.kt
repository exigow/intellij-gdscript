package gdscript.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import junit.framework.TestCase
import uitlities.assertContains
import uitlities.assertNotContains

class DataCompletionContributorTest : BasePlatformTestCase() {

    fun `test sibling files completion`() {
        myFixture.configureByText("player.gd", """x = preload("res://<caret>")""")
        myFixture.addFileToProject("enemy.gd", "extends Node")
        myFixture.addFileToProject("project.godot", "")
        myFixture.completeBasic()
        assertContains(myFixture.lookupElementStrings, "res://enemy.gd")
    }

    fun `test sub directory files completion`() {
        myFixture.configureByText("player.gd", """x = preload("res://<caret>")""")
        myFixture.addFileToProject("inner/inner/enemy.gd", "extends Node")
        myFixture.addFileToProject("project.godot", "")
        myFixture.completeBasic()
        assertContains(myFixture.lookupElementStrings, "res://inner/inner/enemy.gd")
    }

    fun `test do not complete on missing project`() {
        myFixture.configureByText("player.gd", """x = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(myFixture.lookupElementStrings, "res://player.gd")
    }

    fun `test hide all dot-prefixed files`() {
        myFixture.addFileToProject("project.godot", "")
        myFixture.addFileToProject("util.gd", "")
        myFixture.addFileToProject(".import/file.gd", "")
        myFixture.configureByText("player.gd", """x = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(myFixture.lookupElementStrings, "res://.import/file.gd")
        assertContains(myFixture.lookupElementStrings, "res://util.gd")
    }

    fun `test hide "import" extension files`() {
        myFixture.addFileToProject("project.godot", "")
        myFixture.addFileToProject("util.gd", "")
        myFixture.addFileToProject("file.import", "")
        myFixture.configureByText("player.gd", """x = preload("res://<caret>")""")
        myFixture.completeBasic()
        assertNotContains(myFixture.lookupElementStrings, "res://file.import")
        assertContains(myFixture.lookupElementStrings, "res://util.gd")
    }

}
