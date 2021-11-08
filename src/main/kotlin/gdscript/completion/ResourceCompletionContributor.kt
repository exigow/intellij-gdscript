package gdscript.completion


import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder.create
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileVisitor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import common.Icons
import common.ResourceUtil
import gdscript.ScriptFileType
import gdscript.psi.ScriptElementTypes.DOUBLE_QUOTED_STRING
import gdscript.psi.ScriptElementTypes.SINGLE_QUOTED_STRING
import javax.swing.Icon

class ResourceCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val element = parameters.position
        if (isResourceString(element)) {
            val projectFile = ResourceUtil.findProject(element)
                ?: return
            val lookups = findFiles(projectFile.parent)
                .filterNot { file -> file.path == parameters.originalFile.virtualFile.path }
                .map { file -> createLookup(projectFile, file, element.elementType!!) }
            result.addAllElements(lookups)
        }
    }

    private fun isResourceString(element: PsiElement) =
        element.elementType in arrayOf(DOUBLE_QUOTED_STRING, SINGLE_QUOTED_STRING)
            && ResourceUtil.isResource(element.text)

    private fun findFiles(start: VirtualFile): List<VirtualFile> {
        val result = mutableListOf<VirtualFile>()
        VfsUtilCore.visitChildrenRecursively(start, object : VirtualFileVisitor<Any>() {

            override fun visitFile(file: VirtualFile): Boolean {
                val name = file.name
                if (file.isDirectory && name.startsWith("."))
                    return false
                if (!file.isDirectory && !name.startsWith(".") && !name.endsWith(".import") && name != "project.godot")
                    result.add(file)
                return true
            }

        })
        return result
    }

    private fun createLookup(projectFile: VirtualFile, file: VirtualFile, type: IElementType): LookupElement {
        val quote = if (type == DOUBLE_QUOTED_STRING) "\"" else "'"
        val path = VfsUtilCore.findRelativePath(projectFile, file, '/')!!
        val lookup = create("${quote}res://$path")
            .withPresentableText(file.name)
            .withTypeText(path)
            .withIcon(matchIcon(file.extension))
            .withInsertHandler(ReplaceHandler("${quote}res://$path$quote"))
        val priority = prioritizeBy(file.extension)
        return PrioritizedLookupElement.withExplicitProximity(lookup, priority)
    }

    private fun matchIcon(extension: String?): Icon =
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

    private class ReplaceHandler(private val newText: String) : InsertHandler<LookupElement> {

        override fun handleInsert(context: InsertionContext, item: LookupElement) {
            val old = context.file.findElementAt(context.startOffset)!!
            val new = createNewLeaf(context.project)
            old.replace(new)
        }

        private fun createNewLeaf(project: Project): LeafPsiElement {
            val dummyFile = PsiFileFactory.getInstance(project)
                .createFileFromText("dummy.gd", ScriptFileType, newText)
            return dummyFile.node.findLeafElementAt(0) as LeafPsiElement
        }

    }

}

