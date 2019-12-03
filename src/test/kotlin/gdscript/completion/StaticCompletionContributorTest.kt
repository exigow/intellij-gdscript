package gdscript.completion

import gdscript.BaseTest
import uitlities.lookupTexts
import uitlities.openCode

class StaticCompletionContributorTest : BaseTest() {

    fun `test Vector2 class constant`() {
        environment.openCode("one = Vector2.<caret>")
        assertTrue("ONE" in environment.lookupTexts())
    }

    fun `test Input singleton constant`() {
        environment.openCode("is_hidden = Input.<caret>")
        assertTrue("MOUSE_MODE_HIDDEN" in environment.lookupTexts())
    }

    fun `test Input singleton method`() {
        environment.openCode("is_hidden = Input.<caret>")
        assertTrue("is_key_pressed" in environment.lookupTexts())
    }

}
