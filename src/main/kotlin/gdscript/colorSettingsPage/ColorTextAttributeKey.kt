package gdscript.colorSettingsPage

import com.intellij.ide.highlighter.custom.CustomHighlighterColors
import com.intellij.openapi.editor.colors.EditorColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default


enum class ColorTextAttributeKey(copied: TextAttributesKey) {

    LINE_COMMENT(Default.LINE_COMMENT),
    STRING(Default.STRING),
    NUMBER(Default.NUMBER),
    KEYWORD(Default.KEYWORD),
    IDENTIFIER(Default.IDENTIFIER),
    NODE(Default.METADATA),
    OPERATION_SIGN(Default.OPERATION_SIGN),
    COMMA(Default.COMMA),
    SEMICOLON(Default.SEMICOLON),
    COLON(Default.OPERATION_SIGN),
    ARROW(Default.OPERATION_SIGN),
    DOT(Default.DOT),
    BRACES(Default.BRACES),
    PARENTHESES(Default.PARENTHESES),
    BRACKETS(Default.BRACKETS),
    STATIC_METHOD(Default.STATIC_METHOD),
    INSTANCE_FIELD(Default.INSTANCE_FIELD),
    INSTANCE_METHOD(Default.INSTANCE_METHOD),
    CLASS_NAME(CustomHighlighterColors.CUSTOM_KEYWORD3_ATTRIBUTES),
    CONSTANT(Default.CONSTANT),
    RESOURCE(EditorColors.INJECTED_LANGUAGE_FRAGMENT);

    val key: TextAttributesKey =
        createTextAttributesKey("GDSCRIPT_$name", copied)

    companion object {

        fun keys() =
            values().map { it.key }

    }

}