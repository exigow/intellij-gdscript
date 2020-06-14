package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import gdscript.Colors
import gdscript.utils.FileUtils
import gdscript.utils.PsiElementUtils.isStringLeaf
import gdscript.utils.PsiElementUtils.stringText

class ResourceAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.isStringLeaf() && element.stringText().startsWith(RESOURCE_PREFIX)) {
            val filenames = collectProjectFilenames(element)
            if (filenames.isEmpty())
                return
            val path = element.stringText().removePrefix(RESOURCE_PREFIX)
            if (path !in filenames)
                holder.createWeakWarningAnnotation(element, "Cannot resolve resource '$path'")
            else {
                val colored = holder.createInfoAnnotation(element, null)
                colored.textAttributes = Colors.RESOURCE.key
            }
        }
    }

    private fun collectProjectFilenames(element: PsiElement): Set<String> {
        val projectDirectory = element.containingFile.virtualFile.parent
            ?: return emptySet()
        return FileUtils.collectPathsToProjectFiles(projectDirectory).keys
    }

    private companion object {

        private const val RESOURCE_PREFIX = "res://"

    }

}