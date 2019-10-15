package gdscript.lang

import gdscript.GDScriptLexer
import gdscript.GDScriptLexer.*
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet

object TokenSet {

    val WHITESPACE = createTokenSet(ScriptLanguage, GDScriptLexer.WHITESPACE)!!
    val LINE_COMMENT = createTokenSet(ScriptLanguage, GDScriptLexer.LINE_COMMENT)!!
    val STRING = createTokenSet(ScriptLanguage, GDScriptLexer.STRING, MULTILINE_STRING)!!
    val NUMBER = createTokenSet(ScriptLanguage, GDScriptLexer.NUMBER)!!
    val KEYWORD = createTokenSet(ScriptLanguage, MATCH, EXPORT, ONREADY, VAR, SETGET, CONST, STATIC, FUNC, FOR, WHILE, CLASS, EXTENDS, CLASS_NAME, ENUM, IF, ELIF, ELSE, RETURN, PASS, SIGNAL, AND, OR, IN, IS, AS, NOT, TRUE, FALSE, SELF, NULL, BOOL, INT, FLOAT, VOID, TOOL)!!
    val IDENTIFIER = createTokenSet(ScriptLanguage, GDScriptLexer.IDENTIFIER)!!
    val NODE = createTokenSet(ScriptLanguage, GDScriptLexer.NODE)!!
    val OPERATION_SIGN = createTokenSet(ScriptLanguage, NEGATE, ARROW, MINUS, ASSIGN, ASSIGN_SPECIAL, GDScriptLexer.OPERATION_SIGN)!!
    val COMMA = createTokenSet(ScriptLanguage, GDScriptLexer.COMMA)!!
    val DOT = createTokenSet(ScriptLanguage, GDScriptLexer.DOT)!!
    val BRACES = createTokenSet(ScriptLanguage, BRACE_LEFT, BRACE_RIGHT)!!
    val PARENTHESES = createTokenSet(ScriptLanguage, PARENTHES_LEFT, PARENTHES_RIGHT)!!
    val BRACKETS = createTokenSet(ScriptLanguage, BRACKET_LEFT, BRACKET_RIGHT)!!

}
