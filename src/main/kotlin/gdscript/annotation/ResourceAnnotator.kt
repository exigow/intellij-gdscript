package gdscript.annotation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import common.ResourceUtil
import gdscript.psi.ScriptElementTypes.DOUBLE_QUOTED_STRING
import gdscript.psi.ScriptElementTypes.SINGLE_QUOTED_STRING

class ResourceAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (isString(element)) {
            if (!ResourceUtil.isResource(element.text))
                return
            val project: VirtualFile = ResourceUtil.findProject(element) ?: return
            val path: String = ResourceUtil.cleanResource(element.text)
            if (VfsUtilCore.findRelativeFile(path, project) == null)
                holder.createWeakWarningAnnotation(element, "Cannot resolve resource '$path'")
        }
    }

    private fun isString(element: PsiElement) =
        element.elementType == DOUBLE_QUOTED_STRING || element.elementType == SINGLE_QUOTED_STRING

}