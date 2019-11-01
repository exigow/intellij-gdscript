package gdscript.highlight

import gdscript.BaseTest
import uitlities.openResource

class ResourceErrorHighlightingTest : BaseTest() {

    fun `test empty file is still valid`() =
        assertValid("")

    fun `test entry with number and constructor value`() =
        assertValid("0/region = Rect2(28, 92, 132, 84)")

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

    fun `test entry with dot`() =
        assertValid("quality/intended_usage/framebuffer_allocation.mobile = 1")

    fun `test entry boolean false`() =
        assertValid("force/mono = false")

    fun `test entry object argument`() =
        assertValid("bus/1/effect/0/effect = SubResource(1)")

    fun `test entry object multiple arguments`() =
        assertValid("viewport/default_clear_color = Color(0, 0, 0, 1)")

    fun `test entry array empty`() =
        assertValid("singletons = []")

    fun `test entry array path`() =
        assertValid("dest_files = [\"res://.import/sound_shoot.wav-f0f26619cba21d411b53ad23b8788116.sample\"]")

    fun `test entry dictionary empty`() =
        assertValid("empty = {}")

    fun `test entry started with number`() =
        assertValid("2d/default_gravity = 700")

    fun `test entry dictionary single value`() =
        assertValid("player = {\"hp\": 100.0}")

    fun `test entry dictionary multiple values`() =
        assertValid("a = {\"b\": 1, \"c\": 2}")

    fun `test entry dictionary multiline`() =
        assertValid("""
        player = {
            "hp": 100.0
        }
        """)

    fun `test negated number`() =
        assertValid("x = -1")

    fun `test entry with not properly formatted colons`() =
        assertValid("""
        x = [
            1,
            2, 3 
            ,4,
            5
        ]
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
        environment.openResource(code)
        environment.checkHighlighting()
    }

}