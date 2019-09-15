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

)