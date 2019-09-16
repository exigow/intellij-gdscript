package gdscript

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import gdscript.highlight.ConfigHighlighter
import gdscript.languages.ConfigLanguage
import gdscript.utilities.DefaultTextAttributesKeyHumanizer.humanize

class ConfigColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() =
        ConfigLanguage.displayName

    override fun getIcon() =
        ConfigFileType.icon

    override fun getHighlighter() =
        ConfigHighlighter()

    override fun getAttributeDescriptors() =
        ConfigHighlighter.highlighting.keys.map { AttributesDescriptor(humanize(it), it) }.toTypedArray()

    override fun getColorDescriptors() =
        emptyArray<ColorDescriptor>()

    override fun getAdditionalHighlightingTagToDescriptorMap() =
        emptyMap<String, TextAttributesKey>()

    override fun getDemoText() = """
        config_version=4
        name=\"Linux/X11\"
        [input.0]
        _global_script_classes=[]
        sprite/is_opaque=true
        """.trimIndent()

}
