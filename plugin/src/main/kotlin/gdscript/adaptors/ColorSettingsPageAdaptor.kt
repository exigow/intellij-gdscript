package gdscript.adaptors

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import gdscript.languages.ScriptLanguage
import javax.swing.Icon


open class ColorSettingsPageAdaptor(
    private val name: String,
    private val icon: Icon,
    private val demoText: String,
    private val highlighterFactoryAdaptor: SyntaxHighlighterFactoryAdaptor
) : ColorSettingsPage {

    override fun getAdditionalHighlightingTagToDescriptorMap() =
        emptyMap<String,TextAttributesKey>()

    override fun getIcon() =
        icon

    override fun getHighlighter() =
        highlighterFactoryAdaptor.getSyntaxHighlighter(null, null)

    override fun getDemoText() =
        demoText

    override fun getAttributeDescriptors() =
        highlighterFactoryAdaptor.highlighting.keys
        .map { attr -> AttributesDescriptor(humanize(attr), attr) }
        .toTypedArray()

    override fun getColorDescriptors() =
        emptyArray<ColorDescriptor>()

    override fun getDisplayName() =
        name

    private fun humanize(attribute: TextAttributesKey) =
        attribute.externalName
        .trim()
        .split("_")
        .map { it.toLowerCase() }
        .filter { it != "default" }
        .joinToString(" ")
        .capitalize()

}