package uitlities

import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import gdscript.file.ResourceType
import gdscript.file.ScriptType


fun CodeInsightTestFixture.addCode(content: String) {
    configureByText(ScriptType, content)
}

fun CodeInsightTestFixture.addResource(content: String) {
    configureByText(ResourceType, content)
}

fun CodeInsightTestFixture.addCode(filename: String, content: String) {
    configureByText(filename, content)
}

fun CodeInsightTestFixture.addFile(filename: String) {
    addFileToProject(filename, "bla bla")
}

fun CodeInsightTestFixture.checkInfoHighlighting() {
    checkHighlighting(false, true, false)
}
