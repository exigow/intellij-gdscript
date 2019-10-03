package script

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object ScriptHighlighterColors {

    val NUMBER = createTextAttributesKey("GODOT_SCRIPT.NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val STRING = createTextAttributesKey("GODOT_SCRIPT.STRING", DefaultLanguageHighlighterColors.STRING)
    val KEYWORD = createTextAttributesKey("GODOT_SCRIPT.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val METADATA = createTextAttributesKey("GODOT_SCRIPT.METADATA", DefaultLanguageHighlighterColors.METADATA)
    val IDENTIFIER = createTextAttributesKey("GODOT_SCRIPT.IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    val OPERATION_SIGN = createTextAttributesKey("GODOT_SCRIPT._OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN)
    val COMMA = createTextAttributesKey("GODOT_SCRIPT.COMMA", DefaultLanguageHighlighterColors.COMMA)
    val DOT = createTextAttributesKey("GODOT_SCRIPT.DOT", DefaultLanguageHighlighterColors.DOT)
    val BRACES = createTextAttributesKey("GODOT_SCRIPT.BRACES", DefaultLanguageHighlighterColors.BRACES)
    val PARENTHESES = createTextAttributesKey("GODOT_SCRIPT.PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
    val BRACKETS = createTextAttributesKey("GODOT_SCRIPT.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val LINE_COMMENT = createTextAttributesKey("GODOT_SCRIPT.LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

}