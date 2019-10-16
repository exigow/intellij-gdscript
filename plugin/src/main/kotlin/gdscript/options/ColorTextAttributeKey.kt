package gdscript.options

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default


// todo remove enum, create object, remove LINE_COMMENT.key
enum class ColorTextAttributeKey(val key: TextAttributesKey) {

    LINE_COMMENT(createTextAttributesKey("GDSCRIPT_LINE_COMMENT", Default.LINE_COMMENT)),
    STRING(createTextAttributesKey("GDSCRIPT_STRING", Default.STRING)),
    NUMBER(createTextAttributesKey("GDSCRIPT_NUMBER", Default.NUMBER)),
    KEYWORD(createTextAttributesKey("GDSCRIPT_KEYWORD", Default.KEYWORD)),
    IDENTIFIER(createTextAttributesKey("GDSCRIPT_IDENTIFIER", Default.IDENTIFIER)),
    NODE(createTextAttributesKey("GDSCRIPT_METADATA", Default.METADATA)),
    OPERATION_SIGN(createTextAttributesKey("GDSCRIPT_OPERATION_SIGN", Default.OPERATION_SIGN)),
    COMMA(createTextAttributesKey("GDSCRIPT_COMMA", Default.COMMA)),
    DOT(createTextAttributesKey("GDSCRIPT_DOT", Default.DOT)),
    BRACES(createTextAttributesKey("GDSCRIPT_BRACES", Default.BRACES)),
    PARENTHESES(createTextAttributesKey("GDSCRIPT_PARENTHESES", Default.PARENTHESES)),
    BRACKETS(createTextAttributesKey("GDSCRIPT_BRACKETS", Default.BRACKETS)),
    KEYWORD_FUNCTION_CALL(createTextAttributesKey("GDSCRIPT_KEYWORD_FUNCTION_CALL", Default.KEYWORD)),
    STATIC_METHOD(createTextAttributesKey("GDSCRIPT_STATIC_METHOD", Default.STATIC_METHOD)),
    INSTANCE_METHOD(createTextAttributesKey("GDSCRIPT_INSTANCE_METHOD", Default.INSTANCE_METHOD)),
    CLASS_NAME(createTextAttributesKey("GDSCRIPT_CLASS_NAME", Default.CLASS_NAME)),
    CONSTANT(createTextAttributesKey("GDSCRIPT_CONSTANT", Default.CONSTANT)),

}