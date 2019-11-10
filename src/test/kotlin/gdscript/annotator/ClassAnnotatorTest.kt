package gdscript.annotator

import gdscript.BaseTest
import uitlities.openCode
import uitlities.checkInfoHighlighting

class ClassAnnotatorTest : BaseTest() {

    fun `test variable Vector2 type`() {
        environment.openCode("var position: ${info("Vector2")}")
        environment.checkInfoHighlighting()
    }

    fun `test variable String type`() {
        environment.openCode("var name: ${info("String")}")
        environment.checkInfoHighlighting()
    }

    fun `test non built-in class name`() {
        environment.openCode("var x: ${info("SomeClass")}")
        environment.checkInfoHighlighting()
    }

    fun `test extends Node type`() {
        environment.openCode("extends ${info("Node")}")
        environment.checkInfoHighlighting()
    }

    fun `test primitive classes are not highlighted`() {
        environment.openCode("var x: float")
        environment.checkInfoHighlighting()
    }

}