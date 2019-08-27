package gdscript.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import gdscript.GDScript
import gdscript.icons.IconFactory


class GDScriptColorSettingsPage : ColorSettingsPage {

    override fun getAdditionalHighlightingTagToDescriptorMap() = emptyMap<String,TextAttributesKey>()

    override fun getIcon() = IconFactory.createPluginIcon()

    override fun getHighlighter() = GDScriptHighlighterFactory().getSyntaxHighlighter(null, null)

    override fun getDemoText() = GDScriptColorSettingsPage::class.java.getResource("/demo.gd").readText()

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = GDScriptHighlighterColors.all()
        .map { attribute -> AttributesDescriptor(humanize(attribute), attribute) }
        .toTypedArray()

    private fun humanize(attribute: TextAttributesKey) = attribute.externalName
        .trim()
        .split("_")
        .map { it.toLowerCase() }
        .filter { it != "default" }
        .joinToString(" ")
        .capitalize()

    override fun getColorDescriptors() = emptyArray<ColorDescriptor>()

    override fun getDisplayName() = GDScript.displayName

}