package plugin

import com.intellij.psi.PsiDocumentManager
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase
import org.junit.Test


class SomeTest : LightPlatformCodeInsightFixtureTestCase() {

    @Test
    fun `test file lexer`() {
        val code =
                "hello\n" +
                "    1234\n" +
                "\"dolly\""
        myFixture.configureByText(GDScriptFileType, code)
        PsiDocumentManager.getInstance(project).commitAllDocuments()
        val h = myFixture.doHighlighting()
        println(h)
    }

}