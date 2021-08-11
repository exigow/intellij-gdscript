package tscn.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import tscn.psi.TscnResourceString

class TscnResourceStringReference(element: TscnResourceString) :
    PsiReferenceBase<TscnResourceString>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val path: String = element.text
            .removePrefix("\"res://")
            .removeSuffix("\"")
        val project: VirtualFile = findProjectFile(element)
            ?: return null
        val file: VirtualFile = VfsUtilCore.findRelativeFile(path, project)
            ?: return null
        return PsiManager.getInstance(element.project).findFile(file)
    }

}