package script.annotator

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import script.ScriptFileType

abstract class BaseAnnotatorTest : BasePlatformTestCase() {

    fun assertInfo(code: String) {
        myFixture.configureByText(ScriptFileType, code)
        myFixture.checkHighlighting(false, true, false)
    }

}