package gdscript

import BaseTest
import utils.addFile
import utils.addProjectFile
import utils.assertContains


class ScriptReferenceContributorTest : BaseTest() {

    fun `test string reference`() {
        environment.configureByText("a.gd", "const Scene = preload('res://b.gd<caret>')")
        environment.addFile("b.gd")
        environment.addProjectFile()
        val reference = environment.getReferenceAtCaretPositionWithAssertion().resolve() as ScriptFile
        assertEquals("b.gd", reference.name)
    }

    fun `test type id reference navigates to generated code`() {
        environment.configureByText("foo.gd", "extends <caret>Vector2")
        val reference = environment.getReferenceAtCaretPositionWithAssertion().resolve() as ScriptFile
        assertEquals("Vector2.gd", reference.name)
        assertContains("class_name Vector2", reference.text)
    }

}
