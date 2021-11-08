package gdscript.documentation

import BaseTest
import com.intellij.psi.PsiElement
import io.mockk.every
import io.mockk.mockk
import utils.assertContains

class ScriptDocumentationProviderTest : BaseTest() {

    fun `test float primitive`() {
        val docs = getDocumentation("float")
        assertContains("<div class='definition'><pre>float</pre></div>", docs)
        assertContains("<div class='content'>", docs)
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<ul>", docs)
        assertContains("<li><code>float(from: bool) -> float</code></li>", docs)
        assertContains("</ul>", docs)
        assertContains("</div>", docs)
    }

    fun `test RigidBody2D class`() {
        val docs = getDocumentation("RigidBody2D")
        assertContains("<h3>Properties</h3>", docs)
        assertContains("<li><code>applied_torque = 0.0</code></li>", docs)
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<li><code>get_colliding_bodies() -> Array</code></li>", docs)
        assertContains("<h3>Constants</h3>", docs)
        assertContains("<li><code>MODE_KINEMATIC = 3</code></li>", docs)
        assertContains("<h3>Signals</h3", docs)
        assertContains("<li><code>body_entered(body: Node)</code></li>", docs)
    }

    fun `test VisualServer singleton`() {
        val docs = getDocumentation("VisualServer")
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<li><code>canvas_item_set_material(item: RID, material: RID)</code></li>", docs)
    }

    private fun getDocumentation(psiElementText: String): String {
        val element = mockk<PsiElement>(relaxed = true)
        every { element.text } returns psiElementText
        return ScriptDocumentationProvider().generateDoc(element, element)!!
    }

}
