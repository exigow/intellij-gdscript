package gdscript.completion

import gdscript.BaseTest
import uitlities.lookups
import uitlities.openScript

class ClassNameCompletionContributorTest : BaseTest() {

    fun `test name completion from filename`() {
        environment.openScript("Main.gd", "\nclass_name <caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "Main")
    }

    fun `test name completion from underscore-case filename`() {
        environment.openScript("my_utility_script.gd", "\nclass_name <caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "MyUtilityScript")
    }

    fun `test name completion from kebab-case filename`() {
        environment.openScript("my-utility-script.gd", "\nclass_name <caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "MyUtilityScript")
    }

}