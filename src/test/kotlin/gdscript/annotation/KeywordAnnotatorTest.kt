package gdscript.annotation

import BaseTest
import utils.assertHasHighlight
import utils.openScript

class KeywordAnnotatorTest : BaseTest() {

    fun `test preload`() {
        environment.openScript("x = preload(y)")
        assertHasHighlight(environment.doHighlighting(), "preload", "GDSCRIPT_KEYWORD")
    }

    fun `test sin`() {
        environment.openScript("x = sin(y)")
        assertHasHighlight(environment.doHighlighting(), "sin", "GDSCRIPT_KEYWORD")
    }

}
