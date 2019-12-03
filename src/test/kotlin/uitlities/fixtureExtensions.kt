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

fun CodeInsightTestFixture.doCommentAction() {
    performEditorAction(IdeActions.ACTION_COMMENT_LINE)
}

fun CodeInsightTestFixture.lookupTexts(): Collection<String> {
    completeBasic()
    return lookupElementStrings.orEmpty()
}

fun CodeInsightTestFixture.highlightedTexts(): Collection<String> =
    doHighlighting().map { it.text }

fun CodeInsightTestFixture.highlightedDescriptions(): Collection<String> =
    doHighlighting().mapNotNull { it.description }