package gdscript.completion


import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.vfs.VirtualFile
import common.Icons
import gdscript.utils.FileUtils
import gdscript.utils.PsiElementUtils.isStringLeaf
import gdscript.utils.PsiElementUtils.stringText
import javax.swing.Icon

class ResourceCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (element.isStringLeaf() && element.stringText().startsWith("res://")) {
            val currentFile = parameters.originalFile.virtualFile
            val files = FileUtils.collectPathsToProjectFiles(currentFile, ::isUseful)
            for ((path, file) in files) {
                val lookup = createFileLookup(path, file)
                val priority = prioritizeBy(file.extension)
                val prioritized = PrioritizedLookupElement.withExplicitProximity(lookup, priority)
                result.addElement(prioritized)
            }
        }
    }

    private fun isUseful(file: VirtualFile): Boolean {
        val name = file.name
        return !name.startsWith(".")
            && name != "project.godot"
            && !name.endsWith(".import")
    }

    private fun createFileLookup(fileRelativePath: String, file: VirtualFile): LookupElement =
        create("res://$fileRelativePath")
            .withPresentableText(file.name)
            .withTypeText(fileRelativePath)
            .withIcon(findIcon(file.extension))

    private fun findIcon(extension: String?): Icon =
        when (extension) {
            "gd" -> Icons.GDSCRIPT_FILE
            "tscn", "tres" -> Icons.TSCN_FILE
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

