package gdscript

import gdscript.adaptors.ColorSettingsPageAdaptor
import gdscript.languages.ConfigLanguage


class ConfigColorSettingsPage : ColorSettingsPageAdaptor(
    name = ConfigLanguage.displayName,
    icon = ConfigFileType.icon,
    highlighterFactoryAdaptor = ConfigHighlighterFactory(),
    demoText = """
        config_version=4
        name=\"Linux/X11\"
        [input.0]
        _global_script_classes=[]
        sprite/is_opaque=true
        """.trimIndent()

/*

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

 */
)