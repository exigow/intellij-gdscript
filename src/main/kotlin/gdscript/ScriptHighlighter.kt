package gdscript

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gdscript.lexer.ScriptLexerAdapter
import gdscript.psi.ScriptTypes.*

class ScriptHighlighter : SyntaxHighlighterBase() {

    override fun getTokenHighlights(element: IElementType?): Array<TextAttributesKey> =
        pack(matchingToColor(element)?.key)

    override fun getHighlightingLexer() =
        ScriptLexerAdapter()

    private fun matchingToColor(element: IElementType?) = when (element) {
        REMOTE_KEYWORD,
        PUPPET_KEYWORD,
        MASTER_KEYWORD,
        SYNC_KEYWORD,
        REMOTESYNC_KEYWORD,
        MASTERSYNC_KEYWORD,
        PUPPETSYNC_KEYWORD,
        MATCH_KEYWORD,
        EXPORT_KEYWORD,
        ONREADY_KEYWORD,
        SETGET_KEYWORD,
        CONST_KEYWORD,
        STATIC_KEYWORD,
        FUNC_KEYWORD,
        FOR_KEYWORD,
        WHILE_KEYWORD,
        CLASS_KEYWORD,
        EXTENDS_KEYWORD,
        CLASS_NAME_KEYWORD,
        ENUM_KEYWORD,
        IF_KEYWORD,
        ELIF_KEYWORD,
        ELSE_KEYWORD,
        RETURN_KEYWORD,
        SIGNAL_KEYWORD,
        PASS_KEYWORD,
        BREAK_KEYWORD,
        CONTINUE_KEYWORD,
        TOOL_KEYWORD,
        OPERATOR_KEYWORD,
        VAR_KEYWORD,
        TRUE_KEYWORD,
        FALSE_KEYWORD -> Colors.KEYWORD

        CLASS_IDENTIFIER -> Colors.CLASS_NAME
        CONSTANT_IDENTIFIER -> Colors.CONSTANT
        NODE_IDENTIFIER -> Colors.NODE
        IDENTIFIER -> Colors.IDENTIFIER

        DOUBLE_QUOTED_STRING,
        SINGLE_QUOTED_STRING -> Colors.STRING

        DECIMAL_NUMBER,
        INTEGER_NUMBER -> Colors.NUMBER

        LINE_COMMENT -> Colors.LINE_COMMENT

        COMMA -> Colors.COMMA

        ARROW,
        COLON,
        ASSIGN,
        OPERATOR -> Colors.OPERATION_SIGN

        SEMICOLON -> Colors.SEMICOLON

        DOT -> Colors.DOT

        BRACE_LEFT,
        BRACE_RIGHT -> Colors.BRACES

        PARENTH_LEFT,
        PARENTH_RIGHT -> Colors.PARENTHESES

        BRACKET_LEFT,
        BRACKET_RIGHT -> Colors.BRACKETS
        else -> null
    }

}
