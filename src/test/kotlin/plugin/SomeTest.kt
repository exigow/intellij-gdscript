package plugin

import com.intellij.testFramework.LightVirtualFile
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase
import org.junit.Test


class SomeTest : LightPlatformCodeInsightFixtureTestCase() {

    @Test
    fun `test file lexer`() {
        val file = LightVirtualFile("test.gd",
                "hello = 1\n" +
                "if (test) abc = \"words\"\n" +
                "function()\n")
        myFixture.testHighlighting(true, true, true, file)
    }

}