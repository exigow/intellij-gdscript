package plugin.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import plugin.GDScript
import plugin.icons.GDScriptIconFactory


class GDScriptColorSettingsPage : ColorSettingsPage {

    override fun getAdditionalHighlightingTagToDescriptorMap() = emptyMap<String,TextAttributesKey>()

    override fun getIcon() = GDScriptIconFactory.createLogo()

    override fun getHighlighter() = GDScriptHighlighterFactory().getSyntaxHighlighter(null, null)

    override fun getDemoText() = """
        const message = "hello" # this is comment
        func test(a: Vector2, b: float):
            var number = 123.45
    """.trimIndent()

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