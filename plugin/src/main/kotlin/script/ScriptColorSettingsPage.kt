package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class ScriptColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() = ScriptLanguage.displayName

    override fun getIcon() = ScriptFileType.icon

    override fun getHighlighter() = ScriptHighlighter()

    override fun getAttributeDescriptors() = arrayOf(
        AttributesDescriptor("Number", ScriptHighlighterColors.NUMBER),
        AttributesDescriptor("String", ScriptHighlighterColors.STRING),
        AttributesDescriptor("Keyword", ScriptHighlighterColors.KEYWORD),
        AttributesDescriptor("Metadata", ScriptHighlighterColors.METADATA),
        AttributesDescriptor("Identifier", ScriptHighlighterColors.IDENTIFIER),
        AttributesDescriptor("Operator", ScriptHighlighterColors.OPERATION_SIGN),
        AttributesDescriptor("Comma", ScriptHighlighterColors.COMMA),
        AttributesDescriptor("Dot", ScriptHighlighterColors.DOT),
        AttributesDescriptor("Braces", ScriptHighlighterColors.BRACES),
        AttributesDescriptor("Parentheses", ScriptHighlighterColors.PARENTHESES),
        AttributesDescriptor("Brackets", ScriptHighlighterColors.BRACKETS),
        AttributesDescriptor("Line comment", ScriptHighlighterColors.LINE_COMMENT)
    )

    override fun getColorDescriptors() = emptyArray<ColorDescriptor>()

    override fun getAdditionalHighlightingTagToDescriptorMap() = emptyMap<String, TextAttributesKey>()

    override fun getDemoText() = """
        extends Node
        class_name Hero, "res://interface/icons/hero.png"
        export(Texture) var face
        const MAX_HP = 200
        var hp = 100.0 # Health
        var item = Potion()
        enum Class {ROGUE, KNIGHT, WIZARD}
        var armor_color: Color = blueviolet
        func get_damage(is_critical: bool, multiplier: int) -> float:
            var dmg = weapon.damage + skill.get_bonus()
            var array = [1, 2, 3]
            for i in array:
                dmg += i % array[-1]
            return dkg * 0x8F51""".trimIndent()

}
