package gdscript

import com.intellij.openapi.options.colors.AttributesDescriptor
import gdscript.adaptors.ColorSettingsPageAdaptor
import gdscript.languages.ConfigLanguage
import gdscript.utilities.DefaultTextAttributesKeyHumanizer.humanize


class ConfigColorSettingsPage : ColorSettingsPageAdaptor(
    name = ConfigLanguage.displayName,
    icon = ConfigFileType.icon,
    syntaxHighlighter = ConfigHighlighterFactory().getSyntaxHighlighter(null, null),
    descriptors = ConfigHighlighterFactory().highlighting.keys.map { attr -> AttributesDescriptor(humanize(attr), attr) }.toTypedArray(),
    demoText = """
        config_version=4
        name=\"Linux/X11\"
        [input.0]
        _global_script_classes=[]
        sprite/is_opaque=true
        """.trimIndent()

)