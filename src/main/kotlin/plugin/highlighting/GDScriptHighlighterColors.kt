package plugin.highlighting

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object GDScriptHighlighterColors {

    val KEYWORD: TextAttributesKey = DefaultLanguageHighlighterColors.KEYWORD
    val NUMBER: TextAttributesKey = DefaultLanguageHighlighterColors.NUMBER
    val STRING: TextAttributesKey = DefaultLanguageHighlighterColors.STRING
    val LINE_COMMENT: TextAttributesKey = DefaultLanguageHighlighterColors.LINE_COMMENT
    val CLASS_NAME: TextAttributesKey = DefaultLanguageHighlighterColors.CLASS_NAME
    val PARAMETER: TextAttributesKey = DefaultLanguageHighlighterColors.PARAMETER

    fun all() = listOf(KEYWORD, NUMBER, STRING, LINE_COMMENT, CLASS_NAME, PARAMETER)

}