package tscn

import BaseTest
import com.intellij.openapi.actionSystem.IdeActions.ACTION_COMMENT_LINE
import utils.openScript

class TscnCommenterTest : BaseTest() {

    fun `test comment`() {
        environment.configureByText("scene.tscn", "[node<caret>]")
        environment.performEditorAction(ACTION_COMMENT_LINE)
        environment.checkResult(";[node<caret>]")
    }

    fun `test uncomment`() {
        environment.configureByText("scene.tscn", ";[node<caret>]")
        environment.performEditorAction(ACTION_COMMENT_LINE)
        environment.checkResult("[node<caret>]")
    }

    fun `test override existing comment with new comment`() {
        environment.configureByText("scene.tscn", "[node<caret>] ;comment")
        environment.performEditorAction(ACTION_COMMENT_LINE)
        environment.checkResult(";[node<caret>] ;comment")
    }

}