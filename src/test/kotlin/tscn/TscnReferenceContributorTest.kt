package tscn

import BaseTest

class TscnReferenceContributorTest : BaseTest() {

    fun `test sub_resource reference`() {
        environment.configureByText(
            "scene.tscn", """ 
            [sub_resource id=1]            
            [node]
            x = SubResource<caret>(1)                
        """.trimIndent()
        )
        val ref = environment.getReferenceAtCaretPositionWithAssertion()
        assertNotNull(ref.resolve())
    }

    fun `test sub_resource reference not exists`() {
        environment.configureByText(
            "scene.tscn", """ 
            [node]
            x = SubResource<caret>(1)                
        """.trimIndent()
        )
        val ref = environment.getReferenceAtCaretPositionWithAssertion()
        assertNull(ref.resolve())
    }

}
