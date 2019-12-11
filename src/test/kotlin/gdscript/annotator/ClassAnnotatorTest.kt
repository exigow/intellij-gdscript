package gdscript.annotator

import gdscript.BaseTest
import uitlities.*

class ClassAnnotatorTest : BaseTest() {

    fun `test highlight class name as variable type`() {
        environment.openScript("var position: Vector2")
        assertContainsElements(environment.highlights(), "Vector2")
    }

    fun `test highlight custom class as variable type`() {
        environment.openScript("var x: MyClass")
        assertContainsElements(environment.highlights(), "MyClass")
    }

    fun `test highlight Node after "extends" keyword`() {
        environment.openScript("extends Node")
        assertContainsElements(environment.highlights(), "Node")
    }

    fun `test don't highlight primitive classes`() {
        environment.openScript("var x: float")
        assertEmpty(environment.highlights())
    }

}