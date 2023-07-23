package gdscript.annotation

import BaseTest
import utils.assertHasHighlight
import utils.openScript

class ConstantAnnotatorTest : BaseTest() {

    fun `test PI`() {
        environment.openScript("x = PI")
        assertHasHighlight(environment.doHighlighting(), "PI", "GDSCRIPT_CONSTANT")
    }

    fun `test KEY_SPACE`() {
        environment.openScript("key = KEY_SPACE")
        assertHasHighlight(environment.doHighlighting(), "KEY_SPACE", "GDSCRIPT_CONSTANT")
    }

    fun `test non-API constant`() {
        environment.openScript("x = NON_API_CONSTANT")
        assertHasHighlight(environment.doHighlighting(), "NON_API_CONSTANT", "GDSCRIPT_CONSTANT")
    }

}
