package uitlities

import com.intellij.openapi.actionSystem.IdeActions
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import gdscript.fileType.ResourceType
import gdscript.fileType.ScriptType


fun CodeInsightTestFixture.openScript(filename: String, content: String) {
    configureByText(filename, content)
}

fun CodeInsightTestFixture.openScript(content: String) {
    configureByText(ScriptType, content)
}

fun CodeInsightTestFixture.openResource(content: String) {
    configureByText(ResourceType, content)
}

fun CodeInsightTestFixture.addFile(filename: String) {
    addFileToProject(filename, "bla bla")
}

fun CodeInsightTestFixture.addProjectFile() =
    addFile("project.godot")

fun CodeInsightTestFixture.doCommentLineAction() {
    performEditorAction(IdeActions.ACTION_COMMENT_LINE)
}

fun CodeInsightTestFixture.lookups(): Collection<String> =
    lookupElementStrings.orEmpty()

fun CodeInsightTestFixture.highlights(): Collection<String> =
    doHighlighting().map { it.text }
