package config

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

object ConfigColor {

    val KEYWORD = createTextAttributesKey("GODOT_CONFIG_KEYWORD", Default.KEYWORD)
    val IDENTIFIER = createTextAttributesKey("GODOT_CONFIG_IDENTIFIER", Default.IDENTIFIER)
    val NUMBER = createTextAttributesKey("GODOT_CONFIG_NUMBER", Default.NUMBER)
    val STRING = createTextAttributesKey("GODOT_CONFIG_STRING", Default.STRING)
    val LINE_COMMENT = createTextAttributesKey("GODOT_CONFIG_LINE_COMMENT", Default.LINE_COMMENT)

}