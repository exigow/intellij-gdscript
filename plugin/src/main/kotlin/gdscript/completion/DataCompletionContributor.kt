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
        if (parameters.position.parent is StringRule) {
            val allFiles = visitFiles(parameters.file().parent)
            for (file in allFiles) {
                val relative = VfsUtilCore.findRelativePath(parameters.file(), file, '/')!!
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

    private fun visitFiles(start: VirtualFile): Collection<VirtualFile> {
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

}

