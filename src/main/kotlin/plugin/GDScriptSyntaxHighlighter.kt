package plugin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import plugin.parser.GDScriptLexer
import plugin.parser.GDScriptLexer.*
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as DefaultColor


class GDScriptSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return if (tokenType !is TokenIElementType) EMPTY else when (tokenType.antlrTokenType) {
            NUMBER -> pack(DefaultColor.NUMBER)
            STRING, UNTERMINATED_STRING -> pack(DefaultColor.STRING)
            PARAMETER -> pack(DefaultColor.PARAMETER)
            IF, WHILE, EXTENDS, VAR, CONST, FUNC, RETURN, TRUE, FALSE, PASS -> pack(DefaultColor.KEYWORD)
            CLASS_NAME -> pack(DefaultColor.CLASS_NAME)
            LINE_COMMENT -> pack(DefaultColor.LINE_COMMENT)
            else -> EMPTY
        }
    }

    override fun getHighlightingLexer() = ANTLRLexerAdaptor(GDScript, GDScriptLexer(null))

}