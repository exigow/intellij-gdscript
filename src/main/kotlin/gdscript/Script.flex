package gdscript.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import gdscript.psi.ScriptTypes;
import com.intellij.psi.TokenType;

%%

%class ScriptLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{
return;
%eof}

REMOTE_KEYWORD = "remote"
PUPPET_KEYWORD = "puppet"
MASTER_KEYWORD = "master"
SYNC_KEYWORD = "sync"
REMOTESYNC_KEYWORD = "remotesync"
MASTERSYNC_KEYWORD = "mastersync"
PUPPETSYNC_KEYWORD = "puppetsync"
MATCH_KEYWORD = "match"
EXPORT_KEYWORD = "export"
ONREADY_KEYWORD = "onready"
SETGET_KEYWORD = "setget"
CONST_KEYWORD = "const"
STATIC_KEYWORD = "static"
FUNC_KEYWORD = "func"
FOR_KEYWORD = "for"
WHILE_KEYWORD = "while"
CLASS_KEYWORD = "class"
EXTENDS_KEYWORD = "extends"
CLASS_NAME_KEYWORD = "class_name"
ENUM_KEYWORD = "enum"
IF_KEYWORD = "if"
ELIF_KEYWORD = "elif"
ELSE_KEYWORD = "else"
RETURN_KEYWORD = "return"
SIGNAL_KEYWORD = "signal"
PASS_KEYWORD = "pass"
BREAK_KEYWORD = "break"
CONTINUE_KEYWORD = "continue"
TOOL_KEYWORD = "tool"
OPERATOR_KEYWORD = "in" | "and" | "or" | "is" | "as" | "not"
VAR_KEYWORD = "var"
TRUE_KEYWORD = "true"
FALSE_KEYWORD = "false"
SELF_KEYWORD = "self"

CLASS_IDENTIFIER = (([A-Z] [a-z]*) (([A-Z][a-z]*) | ([0-9]))+)
CONSTANT_IDENTIFIER = [A-Z][A-Z0-9_]+
NODE_IDENTIFIER = "$" \p{xidcontinue}+
IDENTIFIER = (\p{xidstart} | "_") \p{xidcontinue}*

DOUBLE_QUOTED_STRING = \"([^\\\"\r\n]|{ESCAPE_SEQUENCE}|(\\[\r\n]))*?(\"|\\)?
SINGLE_QUOTED_STRING = "'" ([^\\\'\r\n] | {ESCAPE_SEQUENCE} | (\\[\r\n]))* ("'"|\\)?
ESCAPE_SEQUENCE = \\[^\r\n]

DECIMAL_NUMBER = ("+" | "-")? [0-9]* ("." [0-9]+)
INTEGER_NUMBER = ("+" | "-")? [0-9]+

LINE_COMMENT = "#" [^\r\n]*
WHITE_SPACE = [\ \r\t\f]+
END_OF_LINE = \n

ARROW = "->"
COLON = ":"
ASSIGN = "=" | ":=" | "+=" | "-=" | "*=" | "/=" | "%=" | "&=" | "|="
OPERATOR = "+" | "-" | "*" | "/" | "%" | "^" | "|"
    | "<" | ">" | "==" | "!=" | ">=" | "<="
    | "<<" | ">>"
    | "!" | "&&" | "||"

COMMA = ","
SEMICOLON = ";"
DOT = "."

BRACE_LEFT = "("
BRACE_RIGHT = ")"
BRACKET_LEFT = "["
BRACKET_RIGHT = "]"
PARENTH_LEFT = "{"
PARENTH_RIGHT = "}"

%%

<YYINITIAL> {
    {REMOTE_KEYWORD} { return ScriptTypes.REMOTE_KEYWORD; }
    {PUPPET_KEYWORD} { return ScriptTypes.PUPPET_KEYWORD; }
    {MASTER_KEYWORD} { return ScriptTypes.MASTER_KEYWORD; }
    {SYNC_KEYWORD} { return ScriptTypes.SYNC_KEYWORD; }
    {REMOTESYNC_KEYWORD} { return ScriptTypes.REMOTESYNC_KEYWORD; }
    {MASTERSYNC_KEYWORD} { return ScriptTypes.MASTERSYNC_KEYWORD; }
    {PUPPETSYNC_KEYWORD} { return ScriptTypes.PUPPETSYNC_KEYWORD; }
    {MATCH_KEYWORD} { return ScriptTypes.MATCH_KEYWORD; }
    {EXPORT_KEYWORD} { return ScriptTypes.EXPORT_KEYWORD; }
    {ONREADY_KEYWORD} { return ScriptTypes.ONREADY_KEYWORD; }
    {SETGET_KEYWORD} { return ScriptTypes.SETGET_KEYWORD; }
    {CONST_KEYWORD} { return ScriptTypes.CONST_KEYWORD; }
    {STATIC_KEYWORD} { return ScriptTypes.STATIC_KEYWORD; }
    {FUNC_KEYWORD} { return ScriptTypes.FUNC_KEYWORD; }
    {FOR_KEYWORD} { return ScriptTypes.FOR_KEYWORD; }
    {WHILE_KEYWORD} { return ScriptTypes.WHILE_KEYWORD; }
    {CLASS_KEYWORD} { return ScriptTypes.CLASS_KEYWORD; }
    {EXTENDS_KEYWORD} { return ScriptTypes.EXTENDS_KEYWORD; }
    {CLASS_NAME_KEYWORD} { return ScriptTypes.CLASS_NAME_KEYWORD; }
    {ENUM_KEYWORD} { return ScriptTypes.ENUM_KEYWORD; }
    {IF_KEYWORD} { return ScriptTypes.IF_KEYWORD; }
    {ELIF_KEYWORD} { return ScriptTypes.ELIF_KEYWORD; }
    {ELSE_KEYWORD} { return ScriptTypes.ELSE_KEYWORD; }
    {RETURN_KEYWORD} { return ScriptTypes.RETURN_KEYWORD; }
    {SIGNAL_KEYWORD} { return ScriptTypes.SIGNAL_KEYWORD; }
    {PASS_KEYWORD} { return ScriptTypes.PASS_KEYWORD; }
    {BREAK_KEYWORD} { return ScriptTypes.BREAK_KEYWORD; }
    {CONTINUE_KEYWORD} { return ScriptTypes.CONTINUE_KEYWORD; }
    {TOOL_KEYWORD} { return ScriptTypes.TOOL_KEYWORD; }
    {OPERATOR_KEYWORD} { return ScriptTypes.OPERATOR_KEYWORD; }
    {VAR_KEYWORD} { return ScriptTypes.VAR_KEYWORD; }
    {TRUE_KEYWORD} { return ScriptTypes.TRUE_KEYWORD; }
    {FALSE_KEYWORD} { return ScriptTypes.FALSE_KEYWORD; }
    {SELF_KEYWORD} { return ScriptTypes.SELF_KEYWORD; }

    {CLASS_IDENTIFIER} { return ScriptTypes.CLASS_IDENTIFIER; }
    {CONSTANT_IDENTIFIER} { return ScriptTypes.CONSTANT_IDENTIFIER; }
    {NODE_IDENTIFIER} { return ScriptTypes.NODE_IDENTIFIER; }
    {IDENTIFIER} { return ScriptTypes.IDENTIFIER; }

    {DOUBLE_QUOTED_STRING} { return ScriptTypes.DOUBLE_QUOTED_STRING; }
    {SINGLE_QUOTED_STRING} { return ScriptTypes.SINGLE_QUOTED_STRING; }

    {DECIMAL_NUMBER} { return ScriptTypes.DECIMAL_NUMBER; }
    {INTEGER_NUMBER} { return ScriptTypes.INTEGER_NUMBER; }

    {IDENTIFIER} { return ScriptTypes.IDENTIFIER; }

    {LINE_COMMENT} { return ScriptTypes.LINE_COMMENT; }
    {WHITE_SPACE} { return TokenType.WHITE_SPACE; }
    {END_OF_LINE} { return TokenType.WHITE_SPACE; }
    {COMMA} { return ScriptTypes.COMMA; }

    {ARROW} { return ScriptTypes.ARROW; }
    {COLON} { return ScriptTypes.COLON; }
    {ASSIGN} { return ScriptTypes.ASSIGN; }
    {OPERATOR} { return ScriptTypes.OPERATOR; }

    {SEMICOLON} { return ScriptTypes.SEMICOLON; }
    {DOT} { return ScriptTypes.DOT; }

    {BRACE_LEFT} { return ScriptTypes.BRACE_LEFT; }
    {BRACE_RIGHT} { return ScriptTypes.BRACE_RIGHT; }
    {BRACKET_LEFT} { return ScriptTypes.BRACKET_LEFT; }
    {BRACKET_RIGHT} { return ScriptTypes.BRACKET_RIGHT; }
    {PARENTH_LEFT} { return ScriptTypes.PARENTH_LEFT; }
    {PARENTH_RIGHT} { return ScriptTypes.PARENTH_RIGHT; }
}
[^] { return TokenType.BAD_CHARACTER; }