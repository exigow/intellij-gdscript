package gdscript.lang.syntaxHighlighter

import ScriptLexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.lang.ScriptLanguage
import gdscript.lang.ScriptTokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import gdscript.colorSettingsPage.ColorTextAttributeKey as Color


class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun matchingToColor(element: IElementType?) = when (element) {
        in ScriptTokenSet.LINE_COMMENTS -> Color.LINE_COMMENT
        in ScriptTokenSet.STRINGS -> Color.STRING
        in ScriptTokenSet.RESOURCES -> Color.RESOURCE
        in ScriptTokenSet.NUMBERS -> Color.NUMBER
        in ScriptTokenSet.KEYWORDS -> Color.KEYWORD
        in ScriptTokenSet.NODES -> Color.NODE
        in ScriptTokenSet.IDENTIFIERS -> Color.IDENTIFIER
        in ScriptTokenSet.CONSTANTS -> Color.CONSTANT
        in ScriptTokenSet.OPERATION_SIGNS -> Color.OPERATION_SIGN
        in ScriptTokenSet.COMMAS -> Color.COMMA
        in ScriptTokenSet.SEMICOLONS -> Color.SEMICOLON
        in ScriptTokenSet.COLONS -> Color.COLON
        in ScriptTokenSet.ARROWS -> Color.ARROW
        in ScriptTokenSet.DOTS -> Color.DOT
        in ScriptTokenSet.BRACES -> Color.BRACES
        in ScriptTokenSet.PARENTHESES -> Color.PARENTHESES
        in ScriptTokenSet.BRACKETS -> Color.BRACKETS
        else -> null
    }

}
