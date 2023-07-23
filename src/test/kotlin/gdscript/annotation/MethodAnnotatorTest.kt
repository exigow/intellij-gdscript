package gdscript.annotation

import BaseTest
import utils.assertHasHighlight
import utils.openScript

class MethodAnnotatorTest : BaseTest() {

    fun `test function`() {
        environment.openScript("func _init():")
        assertHasHighlight(environment.doHighlighting(), "_init", "GDSCRIPT_INSTANCE_METHOD")
    }

    fun `test static function`() {
        environment.openScript("static func add():")
        assertHasHighlight(environment.doHighlighting(), "add", "GDSCRIPT_INSTANCE_METHOD")
    }

}
