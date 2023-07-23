package tscn

import BaseTest
import com.intellij.psi.PsiElement

class TscnReferenceContributorTest : BaseTest() {

    fun `test sub_resource number reference`() {
        val reference = resolveReferenceAtCaret("""
            [sub_resource id=1]            
            [node]
            x = SubResource<caret>(1)     
        """)
        assertNotNull(reference)
    }

    fun `test sub_resource string reference`() {
        val reference = resolveReferenceAtCaret("""
            [sub_resource id="foo"]            
            [node]
            x = SubResource<caret>("foo")     
        """)
        assertNotNull(reference)
    }

    fun `test sub_resource reference not exists`() {
        val reference = resolveReferenceAtCaret(""" 
            [node]
            x = SubResource<caret>(1)                
        """)
        assertNull(reference)
    }

    private fun resolveReferenceAtCaret(code: String): PsiElement? {
        environment.configureByText("scene.tscn", code)
        val reference = environment.getReferenceAtCaretPositionWithAssertion()
        return reference.resolve()
    }

}
