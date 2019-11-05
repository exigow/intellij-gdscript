package gdscript.completion

import gdscript.BaseTest
import uitlities.openCode
import uitlities.assertContains
import uitlities.assertNotContains
import uitlities.lookups

class InvokeCompletionContributorTest : BaseTest() {

    fun `test edit existing function`() {
        environment.openCode("si<caret>(1)")
        environment.completeBasic()
        assertContains(environment.lookups(), "sin")
    }

    fun `test edit existing range function in for statement`() {
        environment.openCode("for i in rang<caret>(1, 2):")
        environment.completeBasic()
        assertContains(environment.lookups(), "range")
    }

    fun `test edit existing constructor`() {
        environment.openCode("Vec<caret>(1, 2)")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

    fun `test edit is case-insensitive`() {
        environment.openCode("vec<caret>(1, 2)")
        environment.completeBasic()
        assertContains(environment.lookups(), "Vector2")
    }

}
