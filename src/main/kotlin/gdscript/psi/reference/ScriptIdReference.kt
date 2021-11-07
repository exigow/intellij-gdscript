package gdscript.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import gdscript.psi.ScriptId
import version.VersionService

class ScriptIdReference(element: ScriptId) :
    PsiReferenceBase<ScriptId>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? =
        if (isKnownClass())
            element
        else
            null

    private fun isKnownClass(): Boolean {
        val current = VersionService.current()
        return (current.classes + current.singletons + current.primitives)
            .any { it.name == element.text }
    }

}