package gdscript.completion

import BaseTest
import utils.lookups
import utils.openScript

class KeywordCompletionContributorTest : BaseTest() {

    fun `test statement after newline surrounded by other statements`() {
        environment.openScript("\nconst X = 123\n<caret>\nvar y = 2")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "var")
        assertContainsElements(environment.lookups(), "func")
        assertContainsElements(environment.lookups(), "const")
    }

    fun `test statement after newline with indent`() {
        environment.openScript("\n    <caret>\n")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "var")
    }

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
