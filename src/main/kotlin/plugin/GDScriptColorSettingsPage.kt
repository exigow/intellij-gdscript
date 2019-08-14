package plugin

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
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

    override fun getDemoText() = """
        const message = "hello" # this is comment
        func test(a: Vector2, b: float):
            var number = 123.45
    """.trimIndent()

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
            AttributesDescriptor("Keyword", DefaultLanguageHighlighterColors.NUMBER),
            AttributesDescriptor("String", DefaultLanguageHighlighterColors.STRING),
            AttributesDescriptor("Line comment", DefaultLanguageHighlighterColors.LINE_COMMENT),
            AttributesDescriptor("Class name", DefaultLanguageHighlighterColors.CLASS_NAME)
        )
    }

}