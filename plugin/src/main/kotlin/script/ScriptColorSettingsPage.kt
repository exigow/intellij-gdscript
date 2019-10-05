package script

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import script.colors.ScriptColor

class ScriptColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() = ScriptLanguage.displayName

    override fun getIcon() = ScriptFileType.icon

    override fun getHighlighter() = ScriptHighlighter()

    override fun getAttributeDescriptors() =
        ScriptColor.values()
        .filterNot { it.hidden }
        .map { AttributesDescriptor(it.displayName, it.key) }
        .toTypedArray()

    override fun getColorDescriptors() = emptyArray<ColorDescriptor>()

    override fun getAdditionalHighlightingTagToDescriptorMap() = emptyMap<String, TextAttributesKey>()

    override fun getDemoText() = """
        extends BaseClass
        class_name MyClass, "res://path/to/icon.svg"
        const ANSWER = 42
        export(String, FILE, "*.txt") var f
        var variable: int = 0 setget set_variable, get_variable
        signal some_signal
        enum Named {THING_1, THING_2, ANOTHER_THING = -1}
        var dict = {
            "key": "value", 
            7: [[1.0, 2.0], [3.0, 4.0]]
        }
        # comment
        func _init(arg, typed: float) -> Vector2:
            ${'$'}Game/Timer.start()
            if (PI > deg2rad(arg)):
                pass
            elif true:
                break
            else:
                print(self.variable)
            return false
        """.trimIndent()

}
