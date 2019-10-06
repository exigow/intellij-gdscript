package script.colors

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

enum class ScriptColor(val displayName: String, val key: TextAttributesKey, val hidden: Boolean = false) {

    NUMBER("Number", createTextAttributesKey("GODOT_SCRIPT.NUMBER", DefaultLanguageHighlighterColors.NUMBER)),
    STRING("String", createTextAttributesKey("GODOT_SCRIPT.STRING", DefaultLanguageHighlighterColors.STRING)),
    KEYWORD("Keyword", createTextAttributesKey("GODOT_SCRIPT.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)),
    IDENTIFIER("Identifier", createTextAttributesKey("GODOT_SCRIPT.IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)),
    NODE_PATH("Node", createTextAttributesKey("GODOT_SCRIPT.NODE_PATH", DefaultLanguageHighlighterColors.METADATA)),
    CONSTANT("Constant", createTextAttributesKey("GODOT_SCRIPT.CONSTANT", DefaultLanguageHighlighterColors.CONSTANT), hidden = true),
    OPERATION_SIGN("Operator sign", createTextAttributesKey("GODOT_SCRIPT.OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN)),
    COMMA("Comma", createTextAttributesKey("GODOT_SCRIPT.COMMA", DefaultLanguageHighlighterColors.COMMA)),
    DOT("Dot", createTextAttributesKey("GODOT_SCRIPT.DOT", DefaultLanguageHighlighterColors.DOT)),
    BRACES("Braces", createTextAttributesKey("GODOT_SCRIPT.BRACES", DefaultLanguageHighlighterColors.BRACES)),
    PARENTHESES("Parentheses", createTextAttributesKey("GODOT_SCRIPT.PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)),
    BRACKETS("Brackets", createTextAttributesKey("GODOT_SCRIPT.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)),
    LINE_COMMENT("Comment line", createTextAttributesKey("GODOT_SCRIPT.LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)),
    BUILT_IN_FUNCTION("Built-in function", createTextAttributesKey("GODOT_SCRIPT.BUILT_IN_FUNCTION", DefaultLanguageHighlighterColors.IDENTIFIER), hidden = true),
    FUNCTION_DECLARATION("Function declaration", createTextAttributesKey("GODOT_SCRIPT.FUNCTION_DECLARATION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION), hidden = true),
    CLASS_TYPE("Class type", createTextAttributesKey("GODOT_SCRIPT.CLASS_TYPE", DefaultLanguageHighlighterColors.CLASS_NAME), hidden = true),
    PRIMITIVE_TYPE("Primitive type", createTextAttributesKey("GODOT_SCRIPT.PRIMITIVE_TYPE", DefaultLanguageHighlighterColors.KEYWORD), hidden = true),

}