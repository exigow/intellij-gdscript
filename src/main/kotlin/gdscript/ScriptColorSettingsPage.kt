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
            class_name MyClass
            extends <GDSCRIPT_CLASS_NAME>RigidBody2D</GDSCRIPT_CLASS_NAME>
            @icon("res://path/to/icon.svg")
            const Scene = <GDSCRIPT_KEYWORD>preload</GDSCRIPT_KEYWORD>('res://scene.tscn')
            const <GDSCRIPT_CONSTANT>MAX_HP</GDSCRIPT_CONSTANT> = -100.0
            enum Named {<GDSCRIPT_CONSTANT>ONE</GDSCRIPT_CONSTANT>, <GDSCRIPT_CONSTANT>TWO</GDSCRIPT_CONSTANT> = -1}
            var hp: float # this is comment
            var multiline = ${"\"\"\""}
                first line
                second line
                ${"\"\"\""}
            func <GDSCRIPT_INSTANCE_METHOD>method</GDSCRIPT_INSTANCE_METHOD>(arg: <GDSCRIPT_CLASS_NAME>Vector2</GDSCRIPT_CLASS_NAME> = <GDSCRIPT_CLASS_NAME>Vector2</GDSCRIPT_CLASS_NAME>.<GDSCRIPT_CONSTANT>ZERO</GDSCRIPT_CONSTANT>) -> int:
                ${'$'}Path/To/Node.items[4] *= <GDSCRIPT_KEYWORD>sin</GDSCRIPT_KEYWORD>(2);
                return <GDSCRIPT_CONSTANT>KEY_SPACE</GDSCRIPT_CONSTANT>
        """.trimIndent()

    }

}