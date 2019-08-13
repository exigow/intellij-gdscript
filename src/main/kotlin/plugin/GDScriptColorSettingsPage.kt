package plugin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon


class GDScriptColorSettingsPage : ColorSettingsPage {

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getIcon(): Icon? {
        return Icons.GODOT_ICON
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return GDScriptSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return "var z = \"hello\" // comment\n"
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Sample"
    }

    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Keyword", GDScriptSyntaxHighlighter.KEYWORD[0]),
            AttributesDescriptor("String", GDScriptSyntaxHighlighter.STRING[0]),
            AttributesDescriptor("Line comment", GDScriptSyntaxHighlighter.LINE_COMMENT[0])
        )
    }

}