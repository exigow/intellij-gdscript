package gdscript

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import gdscript.utilities.BaseSyntaxHighlighterFactory
import gdscript.grammar.ConfigLexer
import gdscript.grammar.ConfigLexer.*
import gdscript.languages.ConfigLanguage

class ConfigHighlighterFactory : BaseSyntaxHighlighterFactory(
    language = ConfigLanguage,
    lexer = ConfigLexer(null),
    highlighting = mapOf(
        DefaultLanguageHighlighterColors.KEYWORD to listOf(KEYWORD, IDENTIFIER),
        DefaultLanguageHighlighterColors.NUMBER to listOf(NUMBER),
        DefaultLanguageHighlighterColors.STRING to listOf(STRING),
        DefaultLanguageHighlighterColors.LINE_COMMENT to listOf(LINE_COMMENT)
    )
)
