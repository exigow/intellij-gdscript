package plugin

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import plugin.parser.GDScriptLexer
import plugin.parser.GDScriptLexer.*


class GDScriptSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return if (tokenType !is TokenIElementType) EMPTY else when (tokenType.antlrTokenType) {
            NUMBER -> pack(DefaultLanguageHighlighterColors.NUMBER)
            STRING -> pack(DefaultLanguageHighlighterColors.STRING)
            PARAMETER -> pack(DefaultLanguageHighlighterColors.PARAMETER)
            IF,
            WHILE,
            EXTENDS,
            VAR,
            CONST,
            FUNC,
            RETURN,
            TRUE,
            FALSE,
            PASS -> pack(DefaultLanguageHighlighterColors.KEYWORD)
            CLASS_NAME -> pack(DefaultLanguageHighlighterColors.CLASS_NAME)
            LINE_COMMENT -> pack(DefaultLanguageHighlighterColors.LINE_COMMENT)
            else -> EMPTY
        }
    }

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(GDScript, GDScriptLexer(null))

}