package gdscript

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class ConfigTestCase : BasePlatformTestCase() {

    fun `test entry name path`() =
        assertValid("screen/orientation = 0")

    fun `test entry name underscore`() =
        assertValid("config_version = 4")

    fun `test entry name starting underscore`() =
        assertValid("_some = 1")

    fun `test entry string`() =
        assertValid("name = \"Linux/X11\"")

    fun `test entry resource path`() =
        assertValid("path = \"res://.import/sound_shoot.wav-f0f26619cba21d411b53ad23b8788116.sample\"")

    fun `test entry number`() =
        assertValid("price = 100")

    fun `test entry boolean true`() =
        assertValid("stretch_2d = true")

    fun `test entry boolean false`() =
        assertValid("force/mono = false")

    fun `test entry object`() =
        assertValid("viewport/default_clear_color = Color(0, 0, 0, 1)")

    fun `test entry array empty`() =
        assertValid("singletons = []")

    fun `test entry array resource path`() =
        assertValid("dest_files = [\"res://.import/sound_shoot.wav-f0f26619cba21d411b53ad23b8788116.sample\"]")

    fun `test entry dictionary empty`() =
        assertValid("empty = {}")

    fun `test entry dictionary single value`() =
        assertValid("player = {\"hp\": 100.0}")

    fun `test entry dictionary multiline`() =
        assertValid("""
        player = {
            "hp": 100.0
        }
        """)

    fun `test section`() =
        assertValid("[input]")

    fun `test section name dots`() =
        assertValid("[preset.1.options]")

    fun `test section name underscore`() =
        assertValid("[sub_resource]")

    fun `test section attribute number`() =
        assertValid("[sub_resource id=3]")

    fun `test section attribute string`() =
        assertValid("[sub_resource type=\"AudioEffectAmplify\"]")

    private fun assertValid(code: String) {
        myFixture.configureByText(ConfigFileType, code)
        myFixture.checkHighlighting()
    }

}