import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.GDScriptFileType

class CommentTestCase : BasePlatformTestCase() {

    fun `test comment`() =
        assertCodeAction("<caret>var x", "#var x")

    fun `test undo comment`() =
        assertCodeAction("<caret>#var x", "var x")

    private fun assertCodeAction(before: String, after: String) {
        myFixture.configureByText(GDScriptFileType, before)
        CommentByLineCommentAction().actionPerformedImpl(project, myFixture.editor);
        myFixture.checkResult(after);
    }

}