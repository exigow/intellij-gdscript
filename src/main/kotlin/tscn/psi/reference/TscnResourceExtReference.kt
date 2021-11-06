package tscn.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.parentOfType
import common.ResourceUtil
import tscn.psi.TscnAttribute
import tscn.psi.TscnExtEntry
import tscn.psi.TscnExtExpression


class TscnResourceExtReference(element: TscnExtExpression) :
    PsiReferenceBase<TscnExtExpression>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val id = element.number.text.toIntOrNull()
            ?: return null
        val entry = PsiTreeUtil.getChildrenOfType(element.containingFile, TscnExtEntry::class.java).orEmpty()
            .flatMap { entry -> PsiTreeUtil.getChildrenOfType(entry, TscnAttribute::class.java).orEmpty().asIterable() }
            .filter { attribute -> attribute.key.text == "id" }
            .find { attribute -> attribute.value.text.toIntOrNull() == id }
            ?.parentOfType(TscnExtEntry::class)
            ?: return null
        val resourcePath = entry.attributeList.find { it.key.text.equals("path") }?.value?.text
            ?: return null
        val path = ResourceUtil.cleanResource(resourcePath)
        val project = ResourceUtil.findProject(element)
            ?: return null
        val file = VfsUtilCore.findRelativeFile(path, project)
            ?: return null
        return PsiManager.getInstance(element.project).findFile(file)
    }

}