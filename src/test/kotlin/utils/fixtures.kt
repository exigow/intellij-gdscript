package utils

import com.intellij.psi.PsiFile
import gdscript.ScriptFileType
import com.intellij.testFramework.fixtures.CodeInsightTestFixture as Fixture

fun Fixture.configureEmpty(filename: String) {
    configureByText(filename, "")
}

// todo rename: configureScript
fun Fixture.openScript(filename: String, content: String) {
    configureByText(filename, content)
}

// todo configureScript
fun Fixture.openScript(content: String): PsiFile
    = configureByText(ScriptFileType, content)

fun Fixture.addFile(filename: String) {
    addFileToProject(filename, "bla bla")
}

fun Fixture.addProjectFile() =
    addFile("project.godot")

fun Fixture.lookups() =
    lookupElementStrings.orEmpty()

fun Fixture.highlights() =
    doHighlighting().map { it.text }
