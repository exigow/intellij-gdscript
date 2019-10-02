package gdscript.colors

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object ConfigHighlighterColors {

    val KEYWORD = createTextAttributesKey("GODOT_CONFIG.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val IDENTIFIER = createTextAttributesKey("GODOT_CONFIG.IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    val NUMBER = createTextAttributesKey("GODOT_CONFIG.NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val STRING = createTextAttributesKey("GODOT_CONFIG.STRING", DefaultLanguageHighlighterColors.STRING)
    val LINE_COMMENT = createTextAttributesKey("GODOT_CONFIG.LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

}