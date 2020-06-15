package gdscript.completion

import BaseTest
import utils.lookups
import utils.openScript

class StaticCompletionContributorTest : BaseTest() {

    fun `test non-singleton class constant field`() {
        environment.openScript("one = Vector2.<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "ONE")
    }

    fun `test singleton class constant`() {
        environment.openScript("is_hidden = Input.<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "MOUSE_MODE_HIDDEN")
    }

    fun `test singleton class static method`() {
        environment.openScript("is_hidden = Input.<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "is_key_pressed")
    }

    fun `test non-singleton class "Vector2" has no method lookups like "length()"`() {
        environment.openScript("Vector2.len<caret>>")
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

}
