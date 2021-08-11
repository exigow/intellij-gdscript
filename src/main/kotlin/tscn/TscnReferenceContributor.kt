package tscn

import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import tscn.psi.TscnExtExpression
import tscn.psi.TscnResourceString
import tscn.psi.TscnSubExpression
import tscn.psi.reference.TscnResourceExtReference
import tscn.psi.reference.TscnResourceStringReference
import tscn.psi.reference.TscnResourceSubReference

class TscnReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(psiElement(TscnResourceString::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> =
                arrayOf(TscnResourceStringReference(element as TscnResourceString))

        })
        registrar.registerReferenceProvider(psiElement(TscnExtExpression::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> =
                arrayOf(TscnResourceExtReference(element as TscnExtExpression))

        })
        registrar.registerReferenceProvider(psiElement(TscnSubExpression::class.java), object : PsiReferenceProvider() {

            override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> =
                arrayOf(TscnResourceSubReference(element as TscnSubExpression))

        })
    }

}