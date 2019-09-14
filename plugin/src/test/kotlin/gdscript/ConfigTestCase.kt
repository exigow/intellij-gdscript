package gdscript

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import gdscript.files.ConfigFileType

class ConfigTestCase : BasePlatformTestCase() {

    fun `test entry number`() =
        assertValid("config_version=4")

    fun `test entry string`() =
        assertValid("name=\"Linux/X11\"")

    fun `test section`() =
        assertValid("[input]")

    fun `test empty array`() =
        assertValid("_global_script_classes=[]")

    fun `test empty dictionary`() =
        assertValid("_global_script_class_icons={}")

    private fun assertValid(code: String) {
        myFixture.configureByText(ConfigFileType, code)
        myFixture.checkHighlighting()
    }

}