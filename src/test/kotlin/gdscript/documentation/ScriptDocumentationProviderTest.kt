package gdscript.documentation

import BaseTest
import com.intellij.codeInsight.documentation.DocumentationManager
import utils.openScript

class ScriptDocumentationProviderTest : BaseTest() {

    fun `test float primitive`() {
        environment.openScript("var x: float<caret>")
        val docs = getDocumentationAtCaret()
        assertContains("<div class='definition'><pre>float</pre></div>", docs)
        assertContains("<div class='content'>", docs)
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<ul>", docs)
        assertContains("<li><code>float(from: bool) -> float</code></li>", docs)
        assertContains("</ul>", docs)
        assertContains("</div>", docs)
    }

    fun `test RigidBody2D class`() {
        environment.openScript("var x: RigidBody2D<caret>")
        val docs = getDocumentationAtCaret()
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
        environment.openScript("var x: VisualServer<caret>")
        val docs = getDocumentationAtCaret()
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<li><code>canvas_item_set_material(item: RID, material: RID)</code></li>", docs)
    }

    private fun getDocumentationAtCaret(): String {
        val element = environment.elementAtCaret
        return DocumentationManager.getProviderFromElement(element)
            .generateDoc(element, element)!!
    }

    private fun assertContains(expectedFragment: String, actual: String) {
        if (expectedFragment !in actual)
            fail("Expected fragment: $expectedFragment\nActual: $actual")
    }

}
