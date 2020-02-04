package gdscript.completion


import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.vfs.VirtualFile
import common.Icons
import common.PsiElementUtils.isToken
import gdscript.ScriptLexer.RESOURCE
import gdscript.completion.utils.FileUtils
import javax.swing.Icon

class ResourceCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (element.isToken(RESOURCE)) {
            val currentFile = parameters.originalFile.virtualFile
            val files = collectUsefulFiles(currentFile)
            for ((path, file) in files) {
                val lookup = createFileLookup(path, file)
                val priority = prioritizeBy(file.extension)
                val prioritized = PrioritizedLookupElement.withExplicitProximity(lookup, priority)
                result.addElement(prioritized)
            }
        }
    }

    private fun collectUsefulFiles(currentFile: VirtualFile) =
        FileUtils.collectPathsToProjectFiles(currentFile) { file ->
            isHiddenFile(file) || isProjectFile(file) || isImportFile(file)
        }

    private fun isHiddenFile(file: VirtualFile) =
        file.name.startsWith(".")

    private fun isProjectFile(file: VirtualFile) =
        file.name == "project.godot"

    private fun isImportFile(file: VirtualFile) =
        file.name.endsWith(".import")

    private fun createFileLookup(fileRelativePath: String, file: VirtualFile): LookupElement =
        create("res://$fileRelativePath")
            .withPresentableText(file.name)
            .withTypeText(fileRelativePath)
            .withIcon(findIcon(file.extension))

    private fun findIcon(extension: String?): Icon =
        when (extension) {
            "gd" -> Icons.GDSCRIPT_FILE
            "tscn", "tres" -> Icons.SCENE_FILE
            "json" -> Icons.JSON_FILE
            else -> Icons.ANY_FILE
        }

    private fun prioritizeBy(extension: String?): Int =
        when (extension) {
            "gd" -> 2
            "tscn" -> 1
            else -> 0
        }

}

