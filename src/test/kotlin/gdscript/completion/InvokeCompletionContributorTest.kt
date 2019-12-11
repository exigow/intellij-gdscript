package gdscript.completion

import gdscript.BaseTest
import uitlities.lookups
import uitlities.openScript

class InvokeCompletionContributorTest : BaseTest() {

    fun `test edit existing function`() {
        environment.openScript("si<caret>(1)")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "sin")
    }

    fun `test edit existing range function in for statement`() {
        environment.openScript("for i in rang<caret>(1, 2):")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "range")
    }

    fun `test edit existing constructor`() {
        environment.openScript("Vec<caret>(1, 2)")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "Vector2")
    }

    fun `test edit existing constructor is case-insensitive`() {
        environment.openScript("vec<caret>(1, 2)")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "Vector2")
    }

}
