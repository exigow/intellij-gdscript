package gdscript.completion


import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import gdscript.icons.IconCatalog
import gdscript.token.ScriptTokenSet
import gdscript.utilities.ProjectFileFinder
import java.util.*
import javax.swing.Icon


class ImportCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(current: CompletionParameters, result: CompletionResultSet) {
        val currentFile = current.originalFile.virtualFile
        val projectFile = ProjectFileFinder.findProject(currentFile)
            ?: return
        if (isResourceLeaf(current.position)) {
            val files = collectUsefulFiles(projectFile.parent) - currentFile
            val lookups = files.map { file ->
                val path = VfsUtilCore.findRelativePath(projectFile, file, '/')!!
                val lookup = createFileLookup(file, path)
                val importance = calculateImportance(file)
                PrioritizedLookupElement.withExplicitProximity(lookup, importance)
            }
            result.addAllElements(lookups)
        }
    }

    private fun isResourceLeaf(position: PsiElement) =
        (position as LeafPsiElement).elementType in ScriptTokenSet.RESOURCES

    private fun createFileLookup(file: VirtualFile, fileRelativePath: String): LookupElement =
        create("res://$fileRelativePath")
            .withPresentableText(file.name)
            .withTypeText(fileRelativePath)
            .withIcon(matchIcon(file))

    private fun calculateImportance(file: VirtualFile): Int =
        when (file.extension) {
            "gd" -> 2
            "tscn" -> 1
            else -> 0
        }

    private fun matchIcon(file: VirtualFile): Icon? =
        when (file.extension) {
            "gd" -> IconCatalog.GODOT_FILE
            "tscn", "tres" -> IconCatalog.RESOURCE_FILE
            "json" -> IconCatalog.JSON_FILE
            else -> IconCatalog.ANY_FILE
        }

    private fun collectUsefulFiles(start: VirtualFile): Collection<VirtualFile> {
        val list = ArrayList<VirtualFile>()
        VfsUtilCore.visitChildrenRecursively(start, object : VirtualFileVisitor<Any>() {
            override fun visitFile(file: VirtualFile): Boolean {
                if (file.name.startsWith("."))
                    return false
                if (!file.isDirectory && file.extension != "import")
                    list.add(file)
                return super.visitFile(file)
            }
        })
        return list
    }

}

