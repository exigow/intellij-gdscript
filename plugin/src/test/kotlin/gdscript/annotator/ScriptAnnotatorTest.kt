package gdscript.annotator

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.files.ScriptFileType

class ScriptAnnotatorTest : BasePlatformTestCase() {

    fun `test variable Vector2 type`() =
        assertInfoHighlighting("var position: ${info("Vector2")}")

    fun `test variable String type`() =
        assertInfoHighlighting("var name: ${info("String")}")

    fun `test extends Node type`() =
        assertInfoHighlighting("extends ${info("Node")}")

    fun `test NUMBER constant`() =
        assertInfoHighlighting("const ${info("NUMBER")} = 100")

    fun `test SOME_VALUE constant`() =
        assertInfoHighlighting("const ${info("SOME_VALUE")} = 0")

    fun `test PI language-level constant`() =
        assertInfoHighlighting("rad = ${info("PI")}")

    fun `test deg2rad function`() =
        assertInfoHighlighting("radians = ${info("deg2rad")}(147)")

    fun `test cosh function`() =
        assertInfoHighlighting("x = ${info("cosh")}(0.13)")

    fun `test function declaration`() =
        assertInfoHighlighting("func ${info("_init")}():")

    fun `test static function declaration`() =
        assertInfoHighlighting("static func ${info("add")}():")

    private fun assertInfoHighlighting(code: String) {
        myFixture.configureByText(ScriptFileType, code + "\n")
        myFixture.checkHighlighting(false, true, false)
    }

    companion object {

        fun info(string: String) = "<info descr=\"null\">$string</info>"

    }

}