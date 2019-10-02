package gdscript.colors

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object ScriptHighlighterColors {

    val NUMBER = createTextAttributesKey("GDSCRIPT.NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val STRING = createTextAttributesKey("GDSCRIPT.STRING", DefaultLanguageHighlighterColors.STRING)
    val KEYWORD = createTextAttributesKey("GDSCRIPT.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val METADATA = createTextAttributesKey("GDSCRIPT.METADATA", DefaultLanguageHighlighterColors.METADATA)
    val IDENTIFIER = createTextAttributesKey("GDSCRIPT.IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    val OPERATION_SIGN = createTextAttributesKey("GDSCRIP._OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN)
    val COMMA = createTextAttributesKey("GDSCRIPT.COMMA", DefaultLanguageHighlighterColors.COMMA)
    val DOT = createTextAttributesKey("GDSCRIPT.DOT", DefaultLanguageHighlighterColors.DOT)
    val BRACES = createTextAttributesKey("GDSCRIPT.BRACES", DefaultLanguageHighlighterColors.BRACES)
    val PARENTHESES = createTextAttributesKey("GDSCRIPT.PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
    val BRACKETS = createTextAttributesKey("GDSCRIPT.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val LINE_COMMENT = createTextAttributesKey("GDSCRIPT.LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val BLOCK_COMMENT = createTextAttributesKey("GDSCRIPT.BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)

}