package gdscript.psi.impl

import com.intellij.psi.PsiReference
import gdscript.psi.ScriptString
import gdscript.psi.reference.ScriptStringReference

object ScriptPsiImplUtil {

    @JvmStatic
    fun getReference(element: ScriptString): PsiReference =
        ScriptStringReference(element)

}