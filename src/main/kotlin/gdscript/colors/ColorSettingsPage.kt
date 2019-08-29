package gdscript.colors

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import gdscript.GDScriptLanguage
import gdscript.highlight.SyntaxHighlighterFactory
import gdscript.icons.Icons


class ColorSettingsPage : com.intellij.openapi.options.colors.ColorSettingsPage {

    override fun getAdditionalHighlightingTagToDescriptorMap() =
        emptyMap<String,TextAttributesKey>()

    override fun getIcon() =
        Icons.FILE_ICON

    override fun getHighlighter() =
        SyntaxHighlighterFactory().getSyntaxHighlighter(null, null)

    override fun getDemoText() =
        ColorSettingsPage::class.java.getResource("/demo.gd").readText()

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> =
        Color.values()
        .map { it.textAttributesKey }
        .map { attr -> AttributesDescriptor(humanize(attr), attr) }
        .toTypedArray()

    override fun getColorDescriptors() =
        emptyArray<ColorDescriptor>()

    override fun getDisplayName() =
        GDScriptLanguage.displayName

    private fun humanize(attribute: TextAttributesKey) =
        attribute.externalName
        .trim()
        .split("_")
        .map { it.toLowerCase() }
        .filter { it != "default" }
        .joinToString(" ")
        .capitalize()

}