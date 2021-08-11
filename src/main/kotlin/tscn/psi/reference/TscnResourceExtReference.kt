package tscn.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import tscn.psi.*


class TscnResourceExtReference(element: TscnExtExpression) :
    PsiReferenceBase<TscnExtExpression>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val id = element.number.text.toIntOrNull() ?: return null
        val entry = findEntryById(id) ?: return null
        val resourcePath = entry.attributeList.find { it.key.text.equals("path") }?.value?.text ?: return null
        val path = resourcePath.removePrefix("\"res://").removeSuffix("\"")
        val project: VirtualFile = findProjectFile(element) ?: return null
        val file: VirtualFile = VfsUtilCore.findRelativeFile(path, project) ?: return null
        return PsiManager.getInstance(element.project).findFile(file)
    }

    private fun findEntryById(id: Int): TscnExtEntry? {
        val entries = PsiTreeUtil.getChildrenOfType(element.containingFile, TscnExtEntry::class.java).orEmpty()
        for (entry in entries) {
            val attributes = PsiTreeUtil.getChildrenOfType(entry, TscnAttribute::class.java).orEmpty()
            for (attribute in attributes) {
                if (attribute.key.text == "id") {
                    val value = attribute.value.text.toIntOrNull()
                    if (value == id)
                        return entry
                }
            }
        }
        return null
    }

}