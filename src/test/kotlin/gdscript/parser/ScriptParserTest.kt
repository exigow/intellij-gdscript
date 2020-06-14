package gdscript.parser

import BaseTest
import com.intellij.testFramework.ParsingTestCase

class ScriptParserTest : BaseTest() {

    fun `test asd`() {
        val code = """
            var x = 1
        """.trimIndent()
        val file = environment.configureByText("test.gd", code)
        ParsingTestCase.ensureParsed(file)
    }

}
