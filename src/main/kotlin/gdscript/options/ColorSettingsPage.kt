package gdscript.options

import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import gdscript.highlight.ScriptHighlighter
import gdscript.icons.IconCatalog
import gdscript.options.ColorTextAttributeKey.*
import gdscript.parser.ScriptLanguage

class ColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() = ScriptLanguage.displayName

    override fun getIcon() = IconCatalog.GODOT_FILE

    override fun getHighlighter() = ScriptHighlighter()

    override fun getAttributeDescriptors() = mapOf(
        LINE_COMMENT to "Line comment",
        STRING to "String text",
        NUMBER to "Number",
        KEYWORD to "Keyword",
        IDENTIFIER to group(IDENTIFIERS, "Identifier"),
        NODE to group(IDENTIFIERS, "Node path"),
        OPERATION_SIGN to group(OPERATORS, "Operation sign"),
        COMMA to group(OPERATORS, "Comma"),
        SEMICOLON to group(OPERATORS, "Semicolon"),
        DOT to group(OPERATORS, "Dot"),
        BRACES to group(OPERATORS, "Braces"),
        PARENTHESES to group(OPERATORS, "Parentheses"),
        BRACKETS to group(OPERATORS, "Brackets"),
        STATIC_METHOD to group(CLASSES, "Static method"),
        INSTANCE_METHOD to group(CLASSES, "Instance method"),
        INSTANCE_FIELD to group(CLASSES, "Instance field"),
        CLASS_NAME to group(CLASSES, "Class name"),
        CONSTANT to group(IDENTIFIERS, "Constant"))
        .map { (color, label) -> AttributesDescriptor(label, color.key) }
        .toTypedArray()

    override fun getColorDescriptors() = emptyArray<ColorDescriptor>()

    override fun getAdditionalHighlightingTagToDescriptorMap() = ColorTextAttributeKey.keys()
        .filter { it.externalName in DEMO_TEXT }
        .map { it.externalName to it }
        .toMap()

    override fun getDemoText() =
        DEMO_TEXT

    private fun group(vararg elements: String) =
        elements.joinToString("//")

    companion object {

        const val OPERATORS = "Braces and operators"
        const val CLASSES = "Classes"
        const val IDENTIFIERS = "Identifiers"
        val DEMO_TEXT = """
        extends <GDSCRIPT_CLASS_NAME>BaseClass</GDSCRIPT_CLASS_NAME>
        const MyScript = preload("res://my_script.gd")
        export(<GDSCRIPT_CLASS_NAME>String</GDSCRIPT_CLASS_NAME>, FILE, "*.txt") var file
        const <GDSCRIPT_CONSTANT>CONSTANT</GDSCRIPT_CONSTANT> = 42 # line comment
        enum Named {<GDSCRIPT_CONSTANT>ONE</GDSCRIPT_CONSTANT> = 1, <GDSCRIPT_CONSTANT>ONE</GDSCRIPT_CONSTANT> = 2}
        func <GDSCRIPT_INSTANCE_METHOD>instance_method</GDSCRIPT_INSTANCE_METHOD>():
            return 1.0
        static func <GDSCRIPT_STATIC_METHOD>static_method</GDSCRIPT_STATIC_METHOD>(parameter1: int, parameter2: <GDSCRIPT_CLASS_NAME>SomeClass</GDSCRIPT_CLASS_NAME>) -> bool:
            ${'$'}Path/To/Node
            var x = 1; y = 2; z = 3;
            if !condition == false:
                var dict = {1: 2, "key": "Hello World"}
                var test = some.<GDSCRIPT_INSTANCE_FIELD>instance_field</GDSCRIPT_INSTANCE_FIELD> * 58.1e-10
            elif true:
                var lua_dict = {key1 = 1, key2 = 2}
            else:
                var array = [1.0, true, "text", [1, 2, 3]]
            print(dict["key"])
            return false
        """.trimIndent()

    }

}