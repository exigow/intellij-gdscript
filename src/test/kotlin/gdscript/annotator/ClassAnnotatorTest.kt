package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class ClassAnnotatorTest : BaseTest() {

    fun `test Vector2 variable`() {
        environment.openCode("var position: Vector2")
        assertTrue("Vector2" in environment.highlightedTexts())
    }

    fun `test String variable`() {
        environment.openCode("var name: String")
        assertTrue("String" in environment.highlightedTexts())
    }

    fun `test custom class variable`() {
        environment.openCode("var x: MyClass")
        assertTrue("MyClass" in environment.highlightedTexts())
    }

    fun `test extends Node`() {
        environment.openCode("extends Node")
        assertTrue("Node" in environment.highlightedTexts())
    }

    fun `test primitive classes are not highlighted`() {
        environment.openCode("var x: float")
        assertEmpty(environment.highlightedTexts())
    }

}