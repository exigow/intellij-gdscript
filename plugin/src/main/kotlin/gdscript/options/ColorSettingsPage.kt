package gdscript.options

import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import gdscript.file.ScriptType
import gdscript.highlight.ScriptHighlighter
import gdscript.options.ColorTextAttributeKey.*
import gdscript.parser.ScriptLanguage

class ColorSettingsPage : ColorSettingsPage {

    override fun getDisplayName() = ScriptLanguage.displayName

    override fun getIcon() = ScriptType.icon

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
        DOT to group(OPERATORS, "Dot"),
        BRACES to group(OPERATORS, "Braces"),
        PARENTHESES to group(OPERATORS, "Parentheses"),
        BRACKETS to group(OPERATORS, "Brackets"),
        STATIC_METHOD to group(CLASSES, "Static method"),
        INSTANCE_METHOD to group(CLASSES, "Instance method"),
        CLASS_NAME to group(CLASSES, "Class name"),
        CONSTANT to group(IDENTIFIERS, "Constant"))
        .map { (color, label) -> AttributesDescriptor(label, color.key) }
        .toTypedArray()

    override fun getColorDescriptors() = emptyArray<ColorDescriptor>()

    // todo use external names from TextAttributeKeys like GDSCRIPT_LINE_COMMENT
    override fun getAdditionalHighlightingTagToDescriptorMap() = mapOf(
        "KEYWORD" to KEYWORD,
        "STATIC_METHOD" to STATIC_METHOD,
        "FUNCTION_DECLARATION" to INSTANCE_METHOD,
        "CLASS_NAME" to CLASS_NAME,
        "CONSTANT" to CONSTANT)
        .map { (key, color) -> key to color.key }
        .toMap()

    override fun getDemoText() = """
        extends <CLASS_NAME>BaseClass</CLASS_NAME>
        const MyScript = <KEYWORD>preload</KEYWORD>("res://my_script.gd")
        export(<CLASS_NAME>String</CLASS_NAME>, FILE, "*.txt") var file
        const <CONSTANT>CONSTANT</CONSTANT> = 42 # line comment
        enum Named {<CONSTANT>ONE</CONSTANT> = 1, <CONSTANT>ONE</CONSTANT> = 2}
        func <FUNCTION_DECLARATION>instance_method</FUNCTION_DECLARATION>():
            return 1.0
        static func <STATIC_METHOD>static_method</STATIC_METHOD>(parameter1: int, parameter2: <CLASS_NAME>SomeClass</CLASS_NAME>) -> bool:
            ${'$'}Path/To/Node
            if !condition == false:
                var dict = {1: 2, "key": "Hello World"}
            elif true:
                var lua_dict = {key1 = 1, key2 = 2}
            else:
                var array = [1.0, true, "text", [1, 2, 3]]
            <KEYWORD>print</KEYWORD>(dict["key"])
            return false
        """.trimIndent()

    private fun group(vararg asd: String) = asd.joinToString("//")

    companion object {

        const val OPERATORS = "Braces and operators"
        const val CLASSES = "Classes"
        const val IDENTIFIERS = "Identifiers"


    }

}