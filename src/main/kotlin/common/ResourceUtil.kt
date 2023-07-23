package common

import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope

object ResourceUtil {

    const val RESOURCE_PREFIX = "res://"

    fun isResource(path: String) =
        path.startsWith("\"$RESOURCE_PREFIX") || path.startsWith("'$RESOURCE_PREFIX")

    fun findResource(resource: PsiElement): PsiFile? {
        if (!isResource(resource.text))
            return null
        val path: String = cleanResource(resource.text)
        val project: VirtualFile = findProject(resource)
            ?: return null
        val file: VirtualFile = VfsUtilCore.findRelativeFile(path, project)
            ?: return null
        return PsiManager.getInstance(resource.project).findFile(file)
    }

    fun cleanResource(path: String) = path
        .removeSurrounding("\"")
        .removeSurrounding("'")
        .removePrefix(RESOURCE_PREFIX)

    fun findProject(resource: PsiElement): VirtualFile? {
        val scope = GlobalSearchScope.projectScope(resource.project)
        return FilenameIndex.getFilesByName(resource.project, "project.godot", scope)
            .map { it.virtualFile }
            .firstOrNull()
    }

}
