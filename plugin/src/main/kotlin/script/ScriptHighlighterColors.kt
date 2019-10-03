package script

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object ScriptHighlighterColors {

    val NUMBER = DefaultLanguageHighlighterColors.NUMBER.wrap()
    val STRING = DefaultLanguageHighlighterColors.STRING.wrap()
    val KEYWORD = DefaultLanguageHighlighterColors.KEYWORD.wrap()
    val METADATA = DefaultLanguageHighlighterColors.METADATA.wrap()
    val IDENTIFIER = DefaultLanguageHighlighterColors.IDENTIFIER.wrap()
    val OPERATION_SIGN = DefaultLanguageHighlighterColors.OPERATION_SIGN.wrap()
    val COMMA = DefaultLanguageHighlighterColors.COMMA.wrap()
    val DOT = DefaultLanguageHighlighterColors.DOT.wrap()
    val BRACES = DefaultLanguageHighlighterColors.BRACES.wrap()
    val PARENTHESES = DefaultLanguageHighlighterColors.PARENTHESES.wrap()
    val BRACKETS = DefaultLanguageHighlighterColors.BRACKETS.wrap()
    val LINE_COMMENT = DefaultLanguageHighlighterColors.LINE_COMMENT.wrap()

    private fun TextAttributesKey.wrap() = createTextAttributesKey("GODOT_SCRIPT.${this.externalName}", this)

}