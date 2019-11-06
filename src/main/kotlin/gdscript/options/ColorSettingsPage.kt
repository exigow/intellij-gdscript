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
        COLON to group(OPERATORS, "Colon"),
        ARROW to group(OPERATORS, "Arrow"),
        DOT to group(OPERATORS, "Dot"),
        BRACES to group(OPERATORS, "Braces"),
        PARENTHESES to group(OPERATORS, "Parentheses"),
        BRACKETS to group(OPERATORS, "Brackets"),
        STATIC_METHOD to group(CLASSES, "Static method"),
        INSTANCE_METHOD to group(CLASSES, "Instance method"),
        INSTANCE_FIELD to group(CLASSES, "Instance field"),
        CLASS_NAME to group(CLASSES, "Class name"),
        CONSTANT to group(IDENTIFIERS, "Constant"),
        RESOURCE to "Resource text")
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
            class_name <GDSCRIPT_CLASS_NAME>MyClass</GDSCRIPT_CLASS_NAME>
            extends <GDSCRIPT_CLASS_NAME>Node</GDSCRIPT_CLASS_NAME>
            const MyScript = preload("res://scripts/MyScript.gd")
            enum MyEnum { <GDSCRIPT_CONSTANT>ONE</GDSCRIPT_CONSTANT>, <GDSCRIPT_CONSTANT>TWO</GDSCRIPT_CONSTANT> = -1 }
            export(<GDSCRIPT_CLASS_NAME>String</GDSCRIPT_CLASS_NAME>) var my_field
            func <GDSCRIPT_INSTANCE_METHOD>_init</GDSCRIPT_INSTANCE_METHOD>(): # line comment
                print("My text");
                if Input.is_action_pressed("my_action"):
                    ${'$'}Path/To/MyNode.<GDSCRIPT_INSTANCE_FIELD>my_field</GDSCRIPT_INSTANCE_FIELD> = {"one": 1, "two": 2}
                    my_field += <GDSCRIPT_CONSTANT>MY_CONSTANT</GDSCRIPT_CONSTANT>
            
            static func <GDSCRIPT_STATIC_METHOD>my_function</GDSCRIPT_STATIC_METHOD>(my_param: <GDSCRIPT_CLASS_NAME>MyClass</GDSCRIPT_CLASS_NAME> = null) -> bool
                return true
            """.trimIndent()

    }

}