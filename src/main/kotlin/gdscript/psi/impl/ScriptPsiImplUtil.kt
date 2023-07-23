package gdscript.psi.impl

import com.intellij.psi.PsiReference
import gdscript.psi.ScriptId
import gdscript.psi.ScriptString
import gdscript.psi.reference.ScriptIdReference
import gdscript.psi.reference.ScriptStringReference

object ScriptPsiImplUtil {

    @JvmStatic
    fun getReference(element: ScriptString): PsiReference =
        ScriptStringReference(element)

    @JvmStatic
    fun getReference(element: ScriptId): PsiReference =
        ScriptIdReference(element)

}
