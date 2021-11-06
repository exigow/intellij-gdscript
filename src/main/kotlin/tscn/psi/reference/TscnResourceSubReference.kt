package tscn.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.parentOfType
import tscn.psi.TscnAttribute
import tscn.psi.TscnSubEntry
import tscn.psi.TscnSubExpression


class TscnResourceSubReference(element: TscnSubExpression) :
    PsiReferenceBase<TscnSubExpression>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        val id = element.number.text.toIntOrNull()
            ?: return null
        return PsiTreeUtil.getChildrenOfType(element.containingFile, TscnSubEntry::class.java).orEmpty()
            .flatMap { entry -> PsiTreeUtil.getChildrenOfType(entry, TscnAttribute::class.java).orEmpty().asIterable() }
            .filter { attribute -> attribute.key.text == "id" }
            .find { attribute -> attribute.value.text.toIntOrNull() == id }
            ?.parentOfType(TscnSubEntry::class)
    }

}