package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import gdscript.GdLanguage
import gdscript.grammar.GdLexer
import gdscript.grammar.GdLexer.*
import gdscript.colors.GdColors as DefaultColors

class GdSyntaxHighlighterFactory : SyntaxHighlighterFactory() {

    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) = object : SyntaxHighlighterBase() {

        override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
            return if (tokenType !is TokenIElementType) EMPTY else when (tokenType.antlrTokenType) {
                NUMBER, HEX -> pack(DefaultColors.NUMBER)
                STRING -> pack(DefaultColors.STRING)
                IDENTIFIER -> pack(DefaultColors.PARAMETER)
                EXPORT, ONREADY, VAR, SETGET,
                CONST,
                STATIC, FUNC,
                FOR, IN,
                WHILE,
                CLASS,
                EXTENDS,
                CLASS_NAME,
                ENUM,
                IF,
                ELIF,
                ELSE,
                RETURN -> pack(DefaultColors.KEYWORD)
                LINE_COMMENT -> pack(DefaultColors.LINE_COMMENT)
                BLOCK_COMMENT -> pack(DefaultColors.BLOCK_COMMENT)
                else -> EMPTY
            }
        }

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(GdLanguage, GdLexer(null))

    }
}
