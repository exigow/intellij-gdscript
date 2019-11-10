package uitlities

import com.intellij.openapi.actionSystem.IdeActions
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import gdscript.fileType.ResourceType
import gdscript.fileType.ScriptType


fun CodeInsightTestFixture.openCode(content: String) {
    configureByText(ScriptType, content)
}

fun CodeInsightTestFixture.openResource(content: String) {
    configureByText(ResourceType, content)
}

fun CodeInsightTestFixture.openCode(filename: String, content: String) {
    configureByText(filename, content)
}

fun CodeInsightTestFixture.addFile(filename: String) {
    addFileToProject(filename, "bla bla")
}

fun CodeInsightTestFixture.addProjectFile() =
    addFile("project.godot")

fun CodeInsightTestFixture.checkInfoHighlighting() =
    checkHighlighting(false, true, false)

fun CodeInsightTestFixture.doCommentAction() =
    performEditorAction(IdeActions.ACTION_COMMENT_LINE)

fun CodeInsightTestFixture.lookups() = lookupElementStrings.orEmpty()