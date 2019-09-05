package gdscript.colors

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

enum class GdColor(val textAttributesKey: TextAttributesKey) {

    KEYWORD(DefaultLanguageHighlighterColors.KEYWORD),
    NUMBER(DefaultLanguageHighlighterColors.NUMBER),
    STRING(DefaultLanguageHighlighterColors.STRING),
    LINE_COMMENT(DefaultLanguageHighlighterColors.LINE_COMMENT),
    BLOCK_COMMENT(DefaultLanguageHighlighterColors.BLOCK_COMMENT),
    PARAMETER(DefaultLanguageHighlighterColors.PARAMETER)

}