package gdscript.completion


import ScriptLexer.RESOURCE
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.vfs.VirtualFile
import gdscript.completion.utils.FileUtils
import gdscript.lang.IconCatalog
import gdscript.lang.psi.PsiElementUtils.token
import javax.swing.Icon

class ImportCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(current: CompletionParameters, result: CompletionResultSet) {
        if (current.position.token() == RESOURCE) {
            val currentFile = current.originalFile.virtualFile
            val files = collectUsefulFiles(currentFile)
            for ((path, file) in files) {
                val lookup = createFileLookup(path, file)
                val importance = matchImportance(file.extension)
                val prioritized = PrioritizedLookupElement.withExplicitProximity(lookup, importance)
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
            .withIcon(matchIcon(file.extension))

    private fun matchImportance(extension: String?): Int =
        when (extension) {
            "gd" -> 2
            "tscn" -> 1
            else -> 0
        }

    private fun matchIcon(extension: String?): Icon? =
        when (extension) {
            "gd" -> IconCatalog.GODOT_FILE
            "tscn", "tres" -> IconCatalog.RESOURCE_FILE
            "json" -> IconCatalog.JSON_FILE
            else -> IconCatalog.ANY_FILE
        }

}

