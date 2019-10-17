package gdscript.options

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
    DOT(Default.DOT),
    BRACES(Default.BRACES),
    PARENTHESES(Default.PARENTHESES),
    BRACKETS(Default.BRACKETS),
    STATIC_METHOD(Default.STATIC_METHOD),
    INSTANCE_METHOD(Default.INSTANCE_METHOD),
    CLASS_NAME(Default.CLASS_NAME),
    CONSTANT(Default.CONSTANT);

    val key: TextAttributesKey =
        createTextAttributesKey(renameKey(copied.externalName), copied)

    private fun renameKey(copied: String) =
        copied.replace("DEFAULT", "GDSCRIPT")

}