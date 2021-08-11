package tscn.psi.reference

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope


fun findProjectFile(resource: PsiElement): VirtualFile? {
    val scope = GlobalSearchScope.projectScope(resource.project)
    return FilenameIndex.getFilesByName(resource.project, "project.godot", scope)
        .map { it.virtualFile }
        .firstOrNull()
}