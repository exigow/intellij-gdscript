package tscn

import BaseTest
import utils.configureEmpty

class TscnBraceMatcherTest : BaseTest() {

    fun `test curly braces`() {
        environment.configureEmpty("f.tscn")
        environment.type('{')
        environment.checkResult("{<caret>}")
    }

    fun `test square braces`() {
        environment.configureEmpty("f.tscn")
        environment.type('[')
        environment.checkResult("[<caret>]")
    }

    fun `test round braces`() {
        environment.configureByText("f.tscn", "<caret>")
        environment.type('(')
        environment.checkResult("(<caret>)")
    }

}