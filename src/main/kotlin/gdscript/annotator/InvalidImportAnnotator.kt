package gdscript.annotator

import ScriptLexer.RESOURCE
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.completion.utils.FileUtils
import gdscript.lang.psi.PsiElementUtils.isToken

class InvalidImportAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isToken(RESOURCE)) {
            val filenames = collectProjectFilenames(element)
            if (filenames.isEmpty())
                return
            val path = extractPath(element.text)
            if (path !in filenames) {
                val message = "Cannot resolve resource '$path'"
                holder.createWeakWarningAnnotation(element, message)
            }
        }
    }

    private fun collectProjectFilenames(element: PsiElement): Set<String> {
        val projectDirectory = element.containingFile.virtualFile.parent
        return FileUtils.collectPathsToProjectFiles(projectDirectory).keys
    }

    private fun extractPath(text: String) = text
        .removeSurrounding("\"")
        .removePrefix("res://")

}