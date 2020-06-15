package gdscript.completion

import BaseTest
import utils.lookups
import utils.openScript

class StaticCompletionContributorTest : BaseTest() {

    fun `test Vector2 constant`() {
        environment.openScript("one = Vector2.<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "ONE")
    }

    fun `test Input constant`() {
        environment.openScript("is_hidden = Input.<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "MOUSE_MODE_HIDDEN")
    }

    fun `test Input method`() {
        environment.openScript("is_hidden = Input.<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "is_key_pressed")
    }

}
