package utils

import com.intellij.openapi.actionSystem.IdeActions
import gdscript.ScriptFileType
import scene.SceneFileType
import com.intellij.testFramework.fixtures.CodeInsightTestFixture as Fixture


fun Fixture.openScript(filename: String, content: String) {
    configureByText(filename, content)
}

fun Fixture.openScript(content: String) {
    configureByText(ScriptFileType, content)
}

fun Fixture.openScene(content: String) {
    configureByText(SceneFileType, content)
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
