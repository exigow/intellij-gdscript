package tscn.psi.impl

import com.intellij.psi.PsiReference
import tscn.psi.TscnExtExpression
import tscn.psi.TscnResourceString
import tscn.psi.TscnSubExpression
import tscn.psi.reference.TscnResourceExtReference
import tscn.psi.reference.TscnResourceStringReference
import tscn.psi.reference.TscnResourceSubReference


object TscnPsiImplUtil {

    @JvmStatic
    fun getReference(element: TscnResourceString): PsiReference =
        TscnResourceStringReference(element)

    @JvmStatic
    fun getReference(element: TscnExtExpression): PsiReference =
        TscnResourceExtReference(element)

    @JvmStatic
    fun getReference(element: TscnSubExpression): PsiReference =
        TscnResourceSubReference(element)

}
