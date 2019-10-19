package gdscript.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.GDScriptLexer
import gdscript.options.ColorTextAttributeKey
import gdscript.parser.ScriptLanguage
import gdscript.token.ScriptTokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor


class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ScriptLanguage, GDScriptLexer(null))

    private fun matchingToColor(element: IElementType?) = when (element) {
        in ScriptTokenSet.LINE_COMMENTS -> ColorTextAttributeKey.LINE_COMMENT
        in ScriptTokenSet.STRINGS -> ColorTextAttributeKey.STRING
        in ScriptTokenSet.NUMBERS -> ColorTextAttributeKey.NUMBER
        in ScriptTokenSet.KEYWORDS -> ColorTextAttributeKey.KEYWORD
        in ScriptTokenSet.NODES -> ColorTextAttributeKey.NODE
        in ScriptTokenSet.IDENTIFIERS -> ColorTextAttributeKey.IDENTIFIER
        in ScriptTokenSet.OPERATION_SIGNS -> ColorTextAttributeKey.OPERATION_SIGN
        in ScriptTokenSet.COMMAS -> ColorTextAttributeKey.COMMA
        in ScriptTokenSet.SEMICOLONS -> ColorTextAttributeKey.SEMICOLON
        in ScriptTokenSet.DOTS -> ColorTextAttributeKey.DOT
        in ScriptTokenSet.BRACES -> ColorTextAttributeKey.BRACES
        in ScriptTokenSet.PARENTHESES -> ColorTextAttributeKey.PARENTHESES
        in ScriptTokenSet.BRACKETS -> ColorTextAttributeKey.BRACKETS
        else -> null
    }

}
