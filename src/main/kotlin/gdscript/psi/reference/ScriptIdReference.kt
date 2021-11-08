package gdscript.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import gdscript.documentation.ScriptGeneratedSourceFileService
import gdscript.psi.ScriptId

class ScriptIdReference(element: ScriptId) :
    PsiReferenceBase<ScriptId>(element, TextRange.from(0, element.textLength)) {

    override fun resolve(): PsiElement? =
        element.project.getService(ScriptGeneratedSourceFileService::class.java)
            .getSourceFile(element.text)

}