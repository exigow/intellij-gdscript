package tscn.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import tscn.psi.TscnAttribute
import tscn.psi.TscnSubEntry
import tscn.psi.TscnSubExpression


class TscnResourceSubReference(element: TscnSubExpression) :
    PsiReferenceBase<TscnSubExpression>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val id = element.number.text.toIntOrNull()
            ?: return null
        return findEntryById(id)
    }

    private fun findEntryById(id: Int): TscnSubEntry? {
        val entries = PsiTreeUtil.getChildrenOfType(element.containingFile, TscnSubEntry::class.java).orEmpty()
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