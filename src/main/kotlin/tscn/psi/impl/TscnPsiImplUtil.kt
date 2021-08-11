package tscn.psi.impl

import com.intellij.psi.PsiReference
import tscn.psi.*
import tscn.psi.reference.TscnResourceExtReference
import tscn.psi.reference.TscnResourceStringReference
import tscn.psi.reference.TscnResourceSubReference


object TscnPsiImplUtil {

    @JvmStatic
    fun getReference(element: TscnResourceString): PsiReference =
        TscnResourceStringReference(element)

    @JvmStatic
    fun getReference(element: TscnExtResourceFunction): PsiReference =
        TscnResourceExtReference(element)

    @JvmStatic
    fun getReference(element: TscnSubResourceFunction): PsiReference =
        TscnResourceSubReference(element)

}