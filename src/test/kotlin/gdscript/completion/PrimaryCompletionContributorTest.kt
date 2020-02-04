package gdscript.completion

import BaseTest
import utils.lookups
import utils.openScript

class PrimaryCompletionContributorTest : BaseTest() {

    fun `test keyword-like variables in expression values`() {
        environment.openScript("x = <caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "self", "null", "false")
    }

    fun `test function invocation as first statement`() {
        environment.openScript("pr<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "print")
    }

    fun `test function invocation`() {
        environment.openScript("var x = si<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "sin")
    }

    fun `test function invocation in dictionary entry value`() {
        environment.openScript("dict = {A = 1, B = si<caret>}")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "sin")
    }

    fun `test class constructor in value expression`() {
        environment.openScript("position = Vec<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "Vector2")
    }

    fun `test primitive class constructor`() {
        environment.openScript("x = flo<caret>")
        environment.completeBasic()
        assertContainsElements(environment.lookups(), "float")
    }

    fun `test completion is not invoked after dot operator expression`() {
        environment.openScript("vector.flo<caret>")
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

    fun `test completion is not invoked inside string expression`() {
        environment.openScript("""x = "flo<caret>" """)
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

    fun `test completion is not invoked while typing numbers`() {
        environment.openScript("x = 1<caret>")
        environment.completeBasic()
        assertEmpty(environment.lookups())
    }

    fun `test move caret automatically after parentheses when function has no arguments`() {
        environment.openScript("prin<caret>")
        environment.completeBasic()
        environment.finishLookup('\r')
        environment.checkResult("print()<caret>")
    }

}
