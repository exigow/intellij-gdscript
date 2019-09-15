package gdscript

import com.intellij.openapi.options.colors.AttributesDescriptor
import gdscript.adaptors.ColorSettingsPageAdaptor
import gdscript.languages.ScriptLanguage
import gdscript.utilities.DefaultTextAttributesKeyHumanizer.humanize


class ScriptColorSettingsPage : ColorSettingsPageAdaptor(
    name = ScriptLanguage.displayName,
    icon = ScriptFileType.icon,
    syntaxHighlighter = ScriptHighlighterFactory().getSyntaxHighlighter(null, null),
    descriptors = ScriptHighlighterFactory().highlighting.keys.map { attr -> AttributesDescriptor(humanize(attr), attr) }.toTypedArray(),
    demoText = """
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

)