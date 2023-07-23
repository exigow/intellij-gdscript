package gdscript

import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import gdscript.psi.ScriptId
import gdscript.psi.ScriptString
import gdscript.psi.reference.ScriptIdReference
import gdscript.psi.reference.ScriptStringReference

class ScriptReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(psiElement(ScriptString::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> =
                arrayOf(ScriptStringReference(element as ScriptString))

        })
        registrar.registerReferenceProvider(psiElement(ScriptId::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> =
                arrayOf(ScriptIdReference(element as ScriptId))

        })
    }

}
