package gdscript.annotator

import gdscript.BaseTest
import uitlities.openCode
import uitlities.checkInfoHighlighting

class ScriptAnnotatorTest : BaseTest() {

    fun `test variable Vector2 type`() {
        environment.openCode("var position: ${info("Vector2")}")
        environment.checkInfoHighlighting()
    }

    fun `test variable String type`() {
        environment.openCode("var name: ${info("String")}")
        environment.checkInfoHighlighting()
    }

    fun `test extends Node type`() {
        environment.openCode("extends ${info("Node")}")
        environment.checkInfoHighlighting()
    }

    fun `test NUMBER constant`() {
        environment.openCode("const ${info("NUMBER")} = 100")
        environment.checkInfoHighlighting()
    }

    fun `test SOME_VALUE constant`() {
        environment.openCode("const ${info("SOME_VALUE")} = 0")
        environment.checkInfoHighlighting()
    }

    fun `test PI language-level constant`() {
        environment.openCode("rad = ${info("PI")}")
        environment.checkInfoHighlighting()
    }

    fun `test deg2rad function`() {
        environment.openCode("radians = ${info("deg2rad")}(147)")
        environment.checkInfoHighlighting()
    }

    fun `test property`() {
        environment.openCode("dir.${info("x")}")
        environment.checkInfoHighlighting()
    }

    fun `test property of property`() {
        environment.openCode("some.${info("inner")}.${info("inner2")}")
        environment.checkInfoHighlighting()
    }

    fun `test cosh function`() {
        environment.openCode("x = ${info("cosh")}(0.13)")
        environment.checkInfoHighlighting()
    }

    fun `test function declaration`() {
        environment.openCode("func ${info("_init")}():")
        environment.checkInfoHighlighting()
    }

    fun `test static function declaration`() {
        environment.openCode("static func ${info("add")}():")
        environment.checkInfoHighlighting()
    }

    companion object {

        fun info(string: String) = "<info descr=\"null\">$string</info>"

    }

}