package gdscript

import BaseTest
import utils.addFile
import utils.addProjectFile


class ScriptReferenceContributorTest : BaseTest() {

    fun `test string reference`() {
        environment.configureByText("a.gd", "const Scene = preload('res://b.gd<caret>')")
        environment.addFile("b.gd")
        environment.addProjectFile()
        val reference = environment.getReferenceAtCaretPositionWithAssertion().resolve() as ScriptFile
        assertEquals("b.gd", reference.name)
    }

}