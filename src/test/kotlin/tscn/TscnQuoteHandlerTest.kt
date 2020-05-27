package tscn

import BaseTest
import utils.configureEmpty

class TscnQuoteHandlerTest : BaseTest() {

    fun `test add double quote`() {
        environment.configureEmpty("f.tscn")
        environment.type('"')
        environment.checkResult("\"<caret>\"")
    }

    fun `test add apostrophe`() {
        environment.configureEmpty("f.tscn")
        environment.type('\'')
        environment.checkResult("\'<caret>\'")
    }

    fun `test remove double quote`() {
        environment.configureByText("f.tscn", "\"<caret>\"")
        environment.type('\b')
        environment.checkResult("<caret>")
    }

    fun `test remove apostrophe`() {
        environment.configureByText("f.tscn", "\'<caret>\'")
        environment.type('\b')
        environment.checkResult("<caret>")
    }

}