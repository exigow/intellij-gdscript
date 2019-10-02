package gdscript

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import gdscript.colors.ConfigHighlighterColors
import gdscript.highlight.ConfigHighlighter
import gdscript.languages.ConfigLanguage

class ConfigColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() =
        ConfigLanguage.displayName

    override fun getIcon() =
        ConfigFileType.icon

    override fun getHighlighter() =
        ConfigHighlighter()

    override fun getAttributeDescriptors() = arrayOf(
        AttributesDescriptor("Keyword", ConfigHighlighterColors.KEYWORD),
        AttributesDescriptor("Identifier", ConfigHighlighterColors.IDENTIFIER),
        AttributesDescriptor("Number", ConfigHighlighterColors.NUMBER),
        AttributesDescriptor("String", ConfigHighlighterColors.STRING),
        AttributesDescriptor("Line comment", ConfigHighlighterColors.LINE_COMMENT)
    )

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
