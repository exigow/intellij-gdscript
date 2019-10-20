package gdscript.completion


import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement.withExplicitProximity
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor
import gdscript.file.ScriptType
import gdscript.psi.StringRule
import java.util.*


class DataCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val project = searchForClosestProjectParent(parameters.file(), maxSearchDepth = 3)
        if (parameters.position.parent is StringRule && project != null) {
            val projectFiles = collectFiles(project.parent)
            for (file in projectFiles) {
                val relative = VfsUtilCore.findRelativePath(project, file, '/')!!
                val lookup = create("res://$relative")
                result.addElement(when (file.extension) {
                    "gd" ->
                        withExplicitProximity(lookup.withPresentableText(file.nameWithoutExtension).withIcon(ScriptType.icon).bold().withTypeText(relative), 2)
                    "tres", "tscn" ->
                        withExplicitProximity(lookup.withPresentableText(relative), 1)
                    else ->
                        withExplicitProximity(lookup.withPresentableText(relative), 0)
                })
            }
        }
    }

    private fun CompletionParameters.file() =
        originalFile.virtualFile

    private fun collectFiles(start: VirtualFile): Collection<VirtualFile> {
        val list = ArrayList<VirtualFile>()
        VfsUtilCore.visitChildrenRecursively(start, object : VirtualFileVisitor<Any>() {
            override fun visitFile(file: VirtualFile): Boolean {
                if (!file.isDirectory)
                    list.add(file)
                return super.visitFile(file)
            }
        })
        return list
    }

    private tailrec fun searchForClosestProjectParent(start: VirtualFile, maxSearchDepth: Int): VirtualFile? {
        val project = start.children.find { it.name == "project.godot" }
        if (project != null)
            return project
        if (maxSearchDepth < 0 || start.parent == null)
            return null
        return searchForClosestProjectParent(start.parent, maxSearchDepth - 1)
    }

}

