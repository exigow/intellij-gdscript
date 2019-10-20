package gdscript.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import uitlities.assertContains

class DataCompletionContributorTest : BasePlatformTestCase() {

    fun `test path completion`() {
        myFixture.configureByText("player.gd", """x = preload("res://<caret>")""")
        myFixture.addFileToProject("enemy.gd", "extends Node")
        myFixture.addFileToProject("items/coin.gd", "extends Node")
        myFixture.addFileToProject("items/other/bonus.gd", "extends Node")
        myFixture.completeBasic()
        assertContains(myFixture.lookupElementStrings, "res://player.gd")
        assertContains(myFixture.lookupElementStrings, "res://enemy.gd")
        assertContains(myFixture.lookupElementStrings, "res://items/coin.gd")
        assertContains(myFixture.lookupElementStrings, "res://items/other/bonus.gd")
    }

}
