package gdscript.completion


import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withExplicitProximity
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VfsUtilCore.findRelativePath
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.icons.IconCatalog
import gdscript.token.ScriptTokenSet
import gdscript.utilities.ProjectFileFinder
import java.util.*
import javax.swing.Icon


class DataCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(current: CompletionParameters, result: CompletionResultSet) {
        val projectFile = ProjectFileFinder.findProject(current.file())
        val projectDir = projectFile?.parent
        if (current.isResource() && projectDir != null) {
            val projectFiles = collectUsefulFiles(projectDir)
            for (file in projectFiles - current.file()) {
                val path = findRelativePath(projectDir, file, '/')!!
                result.addElement(createFileLookup(file, path))
            }
        }
    }

    private fun createFileLookup(file: VirtualFile, path: String): LookupElement {
        val completedText = RESOURCE_PREFIX + path
        val icon = matchIcon(file.extension)
        val importance = matchImportance(file.extension)
        val lookup = create(completedText)
            .withPresentableText(file.name)
            .withTypeText(path)
            .withIcon(icon)
        return withExplicitProximity(lookup, importance)
    }

    private fun matchIcon(extension: String?): Icon? = when (extension) {
        "gd" -> IconCatalog.GODOT_FILE
        "tscn" -> IconCatalog.RESOURCE_FILE
        "json" -> IconCatalog.JSON_FILE
        else -> IconCatalog.ANY_FILE
    }

    private fun matchImportance(extension: String?): Int = when (extension) {
        "gd" -> 3
        "tscn" -> 2
        "import", "godot" -> 0
        else -> 1
    }

    private fun CompletionParameters.file() =
        originalFile.virtualFile

    private fun CompletionParameters.isResource() =
        (position as LeafPsiElement).elementType in ScriptTokenSet.RESOURCES

    private  fun collectUsefulFiles(start: VirtualFile): Collection<VirtualFile> {
        val list = ArrayList<VirtualFile>()
        VfsUtilCore.visitChildrenRecursively(start, object : VirtualFileVisitor<Any>() {
            override fun visitFile(file: VirtualFile): Boolean {
                if (file.isHidden())
                    return false
                if (!file.isDirectory && file.extension != "import")
                    list.add(file)
                return super.visitFile(file)
            }
        })
        return list
    }

    private fun VirtualFile.isHidden() =
        name.startsWith(".")

    companion object {
        const val RESOURCE_PREFIX = "res://"
    }

}

