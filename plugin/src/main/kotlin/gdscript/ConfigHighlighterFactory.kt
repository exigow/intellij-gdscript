package gdscript

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import gdscript.adaptors.ANTLRLexerHighlighter
import gdscript.grammar.ConfigLexer
import gdscript.grammar.ConfigLexer.*
import gdscript.languages.ConfigLanguage
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class ConfigHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = ANTLRLexerHighlighter(ANTLRLexerAdaptor(ConfigLanguage, ConfigLexer(null)), MAP)

    private val MAP = mapOf(
        DefaultLanguageHighlighterColors.KEYWORD to listOf(KEYWORD, IDENTIFIER),
        DefaultLanguageHighlighterColors.NUMBER to listOf(NUMBER),
        DefaultLanguageHighlighterColors.STRING to listOf(STRING),
        DefaultLanguageHighlighterColors.LINE_COMMENT to listOf(LINE_COMMENT)
    )

}
