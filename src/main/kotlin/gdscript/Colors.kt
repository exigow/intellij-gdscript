package gdscript

import com.intellij.ide.highlighter.custom.CustomHighlighterColors
import com.intellij.openapi.editor.colors.EditorColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as DefaultColors

enum class Colors(fallback: TextAttributesKey) {

    LINE_COMMENT(DefaultColors.LINE_COMMENT),
    STRING(DefaultColors.STRING),
    NUMBER(DefaultColors.NUMBER),
    KEYWORD(DefaultColors.KEYWORD),
    IDENTIFIER(DefaultColors.IDENTIFIER),
    NODE(DefaultColors.METADATA),
    COMMA(DefaultColors.COMMA),
    SEMICOLON(DefaultColors.SEMICOLON),
    COLON(DefaultColors.OPERATION_SIGN),
    DOT(DefaultColors.DOT),
    BRACES(DefaultColors.BRACES),
    PARENTHESES(DefaultColors.PARENTHESES),
    BRACKETS(DefaultColors.BRACKETS),
    INSTANCE_METHOD(DefaultColors.INSTANCE_METHOD),
    CLASS_NAME(CustomHighlighterColors.CUSTOM_KEYWORD3_ATTRIBUTES),
    CONSTANT(DefaultColors.CONSTANT),
    RESOURCE(EditorColors.INJECTED_LANGUAGE_FRAGMENT);

    val key: TextAttributesKey =
        TextAttributesKey.createTextAttributesKey("GDSCRIPT_$name", fallback)

}