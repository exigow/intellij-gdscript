package script

import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import script.grammar.ScriptLexer
import script.grammar.ScriptLexer.*

object ScriptTokenSets {

    val WHITESPACE = createTokenSet(ScriptLanguage, ScriptLexer.WHITESPACE)!!
    val LINE_COMMENT = createTokenSet(ScriptLanguage, ScriptLexer.LINE_COMMENT)!!
    val STRING = createTokenSet(ScriptLanguage, ScriptLexer.STRING, MULTILINE_STRING)!!
    val NUMBER = createTokenSet(ScriptLanguage, ScriptLexer.NUMBER)!!
    val KEYWORD = createTokenSet(ScriptLanguage, MATCH, EXPORT, ONREADY, VAR, SETGET, CONST, STATIC, FUNC, FOR, WHILE, CLASS, EXTENDS, CLASS_NAME, ENUM, IF, ELIF, ELSE, RETURN, PASS, SIGNAL, AND, OR, IN, IS, AS, NOT, TRUE, FALSE, SELF, BOOL, INT, FLOAT, VOID)!!
    val IDENTIFIER = createTokenSet(ScriptLanguage, ScriptLexer.IDENTIFIER)!!
    val NODE = createTokenSet(ScriptLanguage, ScriptLexer.NODE)!!
    val OPERATION_SIGN = createTokenSet(ScriptLanguage, ARROW, MINUS, ASSIGN, ASSIGN_SPECIAL, ScriptLexer.OPERATION_SIGN)!!
    val COMMA = createTokenSet(ScriptLanguage, ScriptLexer.COMMA)!!
    val DOT = createTokenSet(ScriptLanguage, ScriptLexer.DOT)!!
    val BRACES = createTokenSet(ScriptLanguage, BRACE_LEFT, BRACE_RIGHT)!!
    val PARENTHESES = createTokenSet(ScriptLanguage, PARENTHES_LEFT, PARENTHES_RIGHT)!!
    val BRACKETS = createTokenSet(ScriptLanguage, BRACKET_LEFT, BRACKET_RIGHT)!!

}
