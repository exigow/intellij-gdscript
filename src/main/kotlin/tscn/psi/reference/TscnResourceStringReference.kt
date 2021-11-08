package tscn.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import common.ResourceUtil
import tscn.psi.TscnResourceString


class TscnResourceStringReference(element: TscnResourceString) :
    PsiReferenceBase<TscnResourceString>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? =
        ResourceUtil.findResource(element)

}