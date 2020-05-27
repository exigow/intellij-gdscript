package gdscript

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor


class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    private fun matchingToColor(element: IElementType?) = when (element) {
        in ScriptTokenSet.LINE_COMMENTS -> Colors.LINE_COMMENT
        in ScriptTokenSet.STRINGS -> Colors.STRING
        in ScriptTokenSet.RESOURCES -> Colors.RESOURCE
        in ScriptTokenSet.NUMBERS -> Colors.NUMBER
        in ScriptTokenSet.KEYWORDS -> Colors.KEYWORD
        in ScriptTokenSet.NODES -> Colors.NODE
        in ScriptTokenSet.IDENTIFIERS -> Colors.IDENTIFIER
        in ScriptTokenSet.CONSTANTS -> Colors.CONSTANT
        in ScriptTokenSet.CLASSES -> Colors.CLASS_NAME
        in ScriptTokenSet.OPERATION_SIGNS -> Colors.OPERATION_SIGN
        in ScriptTokenSet.COMMAS -> Colors.COMMA
        in ScriptTokenSet.SEMICOLONS -> Colors.SEMICOLON
        in ScriptTokenSet.COLONS -> Colors.COLON
        in ScriptTokenSet.DOTS -> Colors.DOT
        in ScriptTokenSet.BRACES -> Colors.BRACES
        in ScriptTokenSet.PARENTHESES -> Colors.PARENTHESES
        in ScriptTokenSet.BRACKETS -> Colors.BRACKETS
        else -> null
    }

}
