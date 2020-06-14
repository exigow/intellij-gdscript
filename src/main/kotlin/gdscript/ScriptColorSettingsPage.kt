package gdscript

import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import common.Icons
import net.pearx.kasechange.toTitleCase

class ScriptColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() =
        ScriptLanguage.displayName

    override fun getIcon() =
        Icons.GDSCRIPT_FILE

    override fun getHighlighter() =
        ScriptHighlighter()

    override fun getAttributeDescriptors() =
        Colors.values()
            .map { AttributesDescriptor(it.name.toTitleCase(), it.key) }
            .toTypedArray()

    override fun getColorDescriptors() =
        emptyArray<ColorDescriptor>()

    override fun getAdditionalHighlightingTagToDescriptorMap() =
        Colors.values()
            .map { it.key }
            .filter { it.externalName in DEMO_TEXT }
            .map { it.toString() to it }
            .toMap()

    override fun getDemoText() =
        DEMO_TEXT

    companion object {

        val DEMO_TEXT = """
            extends Node
            const Scene = preload(<GDSCRIPT_RESOURCE>"res://scene.tscn"</GDSCRIPT_RESOURCE>)
            const <GDSCRIPT_CONSTANT>MAX_HP</GDSCRIPT_CONSTANT> = 100.0
            var hp: float # comment
            enum Named { <GDSCRIPT_CONSTANT>ONE</GDSCRIPT_CONSTANT>, <GDSCRIPT_CONSTANT>TWO</GDSCRIPT_CONSTANT> = "text" } 
            func <GDSCRIPT_INSTANCE_METHOD>get_key</GDSCRIPT_INSTANCE_METHOD>(arg: Vector2 = Vector2.<GDSCRIPT_CONSTANT>ZERO</GDSCRIPT_CONSTANT>) -> int:
                ${'$'}Some/Node.items[4] *= 2;
                return KEY_SPACE
            """.trimIndent()

    }

}