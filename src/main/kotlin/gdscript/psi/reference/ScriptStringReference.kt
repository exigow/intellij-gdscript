package gdscript.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import common.ResourceUtil
import gdscript.psi.ScriptString


class ScriptStringReference(element: ScriptString) :
    PsiReferenceBase<ScriptString>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? =
        ResourceUtil.findResource(element)

}
