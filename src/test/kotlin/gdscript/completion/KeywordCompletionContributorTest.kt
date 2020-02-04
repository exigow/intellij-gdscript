package gdscript.completion

import BaseTest
import utils.lookups
import utils.openScript

class KeywordCompletionContributorTest : BaseTest() {

    fun `test "var" keyword completion after newline`() {
        environment.openScript("\nva<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "var")
    }

    fun `test "const" keyword completion after newline`() {
        environment.openScript("\ncon<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "const")
    }

    fun `test "static" keyword completion after newline`() {
        environment.openScript("\nsta<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "static")
    }

    fun `test "class_name" keyword completion after newline`() {
        environment.openScript("\nclas<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "class_name")
    }

    fun `test "func" keyword completion should add automatically space`() {
        environment.openScript("\nfun<caret>")
        environment.completeBasic()
        environment.finishLookup('\r')
        environment.checkResult("\nfunc <caret>")
    }

}
