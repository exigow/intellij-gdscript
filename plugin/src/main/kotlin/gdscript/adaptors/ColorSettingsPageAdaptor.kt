package gdscript.adaptors

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon


open class ColorSettingsPageAdaptor(
    private val name: String,
    private val icon: Icon,
    private val syntaxHighlighter: SyntaxHighlighter,
    private val descriptors: Array<AttributesDescriptor>,
    private val demoText: String
) : ColorSettingsPage {

    override fun getDisplayName() =
        name

    override fun getIcon() =
        icon

    override fun getHighlighter() =
        syntaxHighlighter

    override fun getAttributeDescriptors() =
        descriptors

    override fun getDemoText() =
        demoText

    override fun getColorDescriptors() =
        emptyArray<ColorDescriptor>()

    override fun getAdditionalHighlightingTagToDescriptorMap() =
        emptyMap<String, TextAttributesKey>()

}