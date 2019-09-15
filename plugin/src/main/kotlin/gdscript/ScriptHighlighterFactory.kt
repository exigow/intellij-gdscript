package gdscript

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import gdscript.utilities.BaseSyntaxHighlighterFactory
import gdscript.grammar.ScriptLexer
import gdscript.grammar.ScriptLexer.*
import gdscript.languages.ScriptLanguage

class ScriptHighlighterFactory : BaseSyntaxHighlighterFactory(
    language = ScriptLanguage,
    lexer = ScriptLexer(null),
    highlighting = mapOf(
        DefaultLanguageHighlighterColors.NUMBER to listOf(NUMBER, HEX),
        DefaultLanguageHighlighterColors.STRING to listOf(STRING),
        DefaultLanguageHighlighterColors.PARAMETER to listOf(IDENTIFIER),
        DefaultLanguageHighlighterColors.KEYWORD to listOf(EXPORT, ONREADY, VAR, SETGET, CONST, STATIC, FUNC, FOR, IN, WHILE, CLASS, EXTENDS, CLASS_NAME, ENUM, IF, ELIF, ELSE, RETURN),
        DefaultLanguageHighlighterColors.LINE_COMMENT to listOf(LINE_COMMENT),
        DefaultLanguageHighlighterColors.BLOCK_COMMENT to listOf(BLOCK_COMMENT)
    )
)