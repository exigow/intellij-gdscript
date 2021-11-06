package gdscript.completion

import BaseTest
import utils.lookups
import utils.openScript

class KeywordContinuationCompletionContributorTest : BaseTest() {

    fun `test export var`() {
        environment.openScript("export <caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "var")
        environment.finishLookup('\r')
        environment.checkResult("export var <caret>")
    }

    fun `test static func`() {
        environment.openScript("static <caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "func")
        environment.finishLookup('\r')
        environment.checkResult("static func <caret>")
    }

    fun `test master func`() {
        environment.openScript("master <caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "func")
        environment.finishLookup('\r')
        environment.checkResult("master func <caret>")
    }

}
