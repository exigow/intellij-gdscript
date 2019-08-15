package plugin.highlighting

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import plugin.GDScript
import plugin.parser.grammar.GDScriptLexer
import plugin.parser.grammar.GDScriptLexer.*
import plugin.highlighting.GDScriptHighlighterColors as DefaultColors

class GDScriptHighlighterFactory : SyntaxHighlighterFactory() {

    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) = object : SyntaxHighlighterBase() {

        override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
            return if (tokenType !is TokenIElementType) EMPTY else when (tokenType.antlrTokenType) {
                NUMBER -> pack(DefaultColors.NUMBER)
                STRING -> pack(DefaultColors.STRING)
                NAME -> pack(DefaultColors.PARAMETER)
                PARENTHESES -> pack(DefaultColors.PARENTHESES)
                KEYWORD -> pack(DefaultColors.KEYWORD)
                LINE_COMMENT -> pack(DefaultColors.LINE_COMMENT)
                else -> EMPTY
            }
        }

        override fun getHighlightingLexer() = ANTLRLexerAdaptor(GDScript, GDScriptLexer(null))

    }
}
