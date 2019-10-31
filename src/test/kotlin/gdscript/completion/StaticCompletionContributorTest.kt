package gdscript.completion

import gdscript.BaseTest
import uitlities.*

class StaticCompletionContributorTest : BaseTest() {

    fun `test class constant`() {
        environment.openCode("one = Vector2.<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "ONE")
    }

    fun `test singleton constant`() {
        environment.openCode("is_hidden = Input.<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "MOUSE_MODE_HIDDEN")
    }

    fun `test singleton method`() {
        environment.openCode("is_hidden = Input.<caret>")
        environment.completeBasic()
        assertContains(environment.lookups(), "is_key_pressed")
    }

}
