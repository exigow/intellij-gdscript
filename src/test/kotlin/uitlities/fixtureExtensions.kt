package uitlities

import com.intellij.openapi.actionSystem.IdeActions
import gdscript.fileType.ResourceType
import gdscript.fileType.ScriptType
import com.intellij.testFramework.fixtures.CodeInsightTestFixture as Fixture


fun Fixture.openScript(filename: String, content: String) {
    configureByText(filename, content)
}

fun Fixture.openScript(content: String) {
    configureByText(ScriptType, content)
}

fun Fixture.openResource(content: String) {
    configureByText(ResourceType, content)
}

fun Fixture.addFile(filename: String) {
    addFileToProject(filename, "bla bla")
}

fun Fixture.addProjectFile() =
    addFile("project.godot")

fun Fixture.doCommentLineAction() {
    performEditorAction(IdeActions.ACTION_COMMENT_LINE)
}

fun Fixture.lookups() =
    lookupElementStrings.orEmpty()

fun Fixture.highlights() =
    doHighlighting().map { it.text }
