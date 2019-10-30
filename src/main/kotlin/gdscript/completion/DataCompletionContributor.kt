package gdscript.completion


import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withExplicitProximity
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.vfs.VfsUtilCore.findRelativePath
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.completion.lookups.DataLookups.createClass
import gdscript.completion.lookups.DataLookups.createFile
import gdscript.completion.utilities.FileUtil.collectAllFiles
import gdscript.completion.utilities.FileUtil.findProjectFile
import gdscript.token.ScriptTokenSet


class DataCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(current: CompletionParameters, result: CompletionResultSet) {
        val projectDir = findProjectFile(current.file())?.parent
        if (current.isString() && current.startsWithResourceText() && projectDir != null) {
            val projectFiles = collectAllFiles(projectDir)
            for (file in projectFiles - current.file()) {
                val path = findRelativePath(projectDir, file, '/')!!
                result.addElement(createFileLookup(file, path))
            }
        }
    }

    private fun createFileLookup(file: VirtualFile, path: String): LookupElement {
        val completedText = "res://$path"
        return when (file.extension) {
            "gd" ->
                withExplicitProximity(createClass(file.nameWithoutExtension, path, completedText), 3)
            "tscn" ->
                withExplicitProximity(createFile(path, completedText), 2)
            "import", "godot" ->
                withExplicitProximity(createFile(path, completedText), 0)
            else ->
                withExplicitProximity(createFile(path, completedText), 1)
        }
    }

    private fun CompletionParameters.file() =
        originalFile.virtualFile

    private fun CompletionParameters.isString() =
        (position as LeafPsiElement).elementType in ScriptTokenSet.STRINGS

    private fun CompletionParameters.startsWithResourceText() =
        position.text.startsWith("\"res://")

}

