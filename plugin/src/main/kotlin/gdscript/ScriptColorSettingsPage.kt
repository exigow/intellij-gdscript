package gdscript

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import gdscript.highlight.ScriptHighlighter
import gdscript.languages.ScriptLanguage
import gdscript.utilities.DefaultTextAttributesKeyHumanizer.humanize

class ScriptColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() =
        ScriptLanguage.displayName

    override fun getIcon() =
        ScriptFileType.icon

    override fun getHighlighter() =
        ScriptHighlighter()

    override fun getAttributeDescriptors() =
        ScriptHighlighter.highlighting.keys.map { AttributesDescriptor(humanize(it), it) }.toTypedArray()

    override fun getColorDescriptors() =
        emptyArray<ColorDescriptor>()

    override fun getAdditionalHighlightingTagToDescriptorMap() =
        emptyMap<String, TextAttributesKey>()

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
