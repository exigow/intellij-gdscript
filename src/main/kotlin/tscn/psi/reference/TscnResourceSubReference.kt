package tscn.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import tscn.psi.TscnAttribute
import tscn.psi.TscnSubResourceEntry
import tscn.psi.TscnSubResourceFunction


class TscnResourceSubReference(element: TscnSubResourceFunction) :
    PsiReferenceBase<TscnSubResourceFunction>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val id = element.number.text.toIntOrNull()
            ?: return null
        return findEntryById(id)
    }

    private fun findEntryById(id: Int): TscnSubResourceEntry? {
        val entries = PsiTreeUtil.getChildrenOfType(element.containingFile, TscnSubResourceEntry::class.java).orEmpty()
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