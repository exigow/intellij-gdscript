package tscn

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import tscn.psi.*
import tscn.psi.reference.TscnResourceExtReference
import tscn.psi.reference.TscnResourceStringReference
import tscn.psi.reference.TscnResourceSubReference

class TscnReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(TscnResourceString::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                if (element is TscnResourceString)
                    return arrayOf(TscnResourceStringReference(element))
                return emptyArray()
            }

        })
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(TscnExtResourceFunction::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                if (element is TscnExtResourceFunction)
                    return arrayOf(TscnResourceExtReference(element))
                return emptyArray()
            }

        })
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(TscnSubResourceFunction::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                if (element is TscnSubResourceFunction)
                    return arrayOf(TscnResourceSubReference(element))
                return emptyArray()
            }

        })
    }

}