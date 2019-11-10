package gdscript.annotator

import ScriptLexer.RESOURCE
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import gdscript.completion.utils.FileUtils
import gdscript.lang.psi.PsiElementUtils.token

class InvalidImportAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.token() == RESOURCE) {
            val path = extractPath(element.text)
            val foundPaths = collectProjectFiles(element).keys
            if (foundPaths.isEmpty())
                return
            if (path !in foundPaths)
                holder.createWeakWarningAnnotation(element, """Cannot resolve resource "$path"""")
        }
    }

    private fun collectProjectFiles(element: PsiElement): Map<String, VirtualFile> {
        val projectDirectory = element.containingFile.virtualFile.parent
        return FileUtils.collectPathsToProjectFiles(projectDirectory)
    }

    private fun extractPath(text: String) =
        text.removeSurrounding("\"").removePrefix("res://")

}