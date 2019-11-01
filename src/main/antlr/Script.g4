grammar Script;

import KeywordLexer, ConstantLexer, FunctionLexer, CoreLexer;

file: separator* (line (separator+ line?)*)? EOF;

separator: NL | SEMICOLON;

line: var_line
    | const_line
    | func_line
    | for_line
    | while_line
    | class_line
    | extends_line
    | class_name_line
    | enum_line
    | if_line
    | elif_line
    | else_line
    | return_line
    | signal_line
    | match_line
    | match_entry_line
    | pass_line
    | break_line
    | continue_line
    | tool_line
    | expression_line;

var_line: (PUPPET | MASTER)? (EXPORT (PARENTHES_LEFT arguments PARENTHES_RIGHT)?)? ONREADY? VAR IDENTIFIER (COLON type)? ((EQUALS | INFER) expression)? (SETGET IDENTIFIER? (COMMA IDENTIFIER)?)?;
const_line: CONST IDENTIFIER (COLON type)? (EQUALS | INFER) expression;
func_line: (STATIC | PUPPET | MASTER | SYNC | REMOTE)? FUNC IDENTIFIER PARENTHES_LEFT func_argument? (COMMA func_argument)* PARENTHES_RIGHT (ARROW type)? COLON;
func_argument: IDENTIFIER (COLON type)? (EQUALS expression)?;
class_line: CLASS IDENTIFIER (EXTENDS type)? COLON;
extends_line: EXTENDS (type | string) (DOT type)*;
enum_line: ENUM IDENTIFIER? BRACE_LEFT NL* enum_argument (COMMA NL* enum_argument)* BRACE_RIGHT;
signal_line: SIGNAL IDENTIFIER (PARENTHES_LEFT arguments PARENTHES_RIGHT)?;
enum_argument: IDENTIFIER (EQUALS expression)? NL*;
while_line: WHILE expression COLON;
for_line: FOR expression COLON;
if_line: IF expression COLON expression?;
elif_line: ELIF expression COLON expression?;
else_line: ELSE COLON expression?;
return_line: RETURN expression?;
match_line: MATCH expression COLON;
match_entry_line: expression COLON;
expression_line: expression;
class_name_line: CLASS_NAME IDENTIFIER;
pass_line: PASS;
break_line: BREAK;
continue_line: CONTINUE;
tool_line: TOOL;

expression: value (instance_field_expression | instance_method_expression | type_operator_expression | subscribe_expression | operator_expression)*;
instance_field_expression: DOT IDENTIFIER;
instance_method_expression: DOT invoke;
type_operator_expression: (AS | IS) value;
subscribe_expression: (BRACKET_LEFT expression BRACKET_RIGHT)+;
operator_expression: (EQUALS | INFER | ASSIGN | MINUS | OTHER_OPERATORS | SLASH | COMPARE | AND | OR | IN | IF | ELSE) value;

value: (MINUS | NOT | NOT_BITWISE | NOT_BOOLEAN)? (CONSTANT | IDENTIFIER | NODE | TRUE | FALSE | SELF | NULL | NUMBER | string | array | dictionary | dictionary_lua | invoke | in_braces | type);
array: BRACKET_LEFT arguments BRACKET_RIGHT;
dictionary: BRACE_LEFT NL* dictionary_entry? (COMMA NL* dictionary_entry)* BRACE_RIGHT;
dictionary_entry: (string | NUMBER) COLON expression NL*;
dictionary_lua: BRACE_LEFT NL* dictionary_lua_entry? (COMMA NL* dictionary_lua_entry)* BRACE_RIGHT;
dictionary_lua_entry: IDENTIFIER EQUALS expression NL*;
invoke: DOT? (IDENTIFIER | FUNCTION | primitive) PARENTHES_LEFT arguments PARENTHES_RIGHT;
in_braces: PARENTHES_LEFT expression PARENTHES_RIGHT;
arguments: NL* expression? NL* (COMMA NL* expression)* NL*;
type: IDENTIFIER | primitive;
primitive: BOOL | INT | FLOAT | VOID;
string: STRING | RESOURCE;

ASSIGN: '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=';
INFER: ':=';
ARROW: '->';
OTHER_OPERATORS: '+' | '*' | '%' | '<<' | '>>' | '&' | '^' | '|' | '&&' | '||';
COMPARE: '<' | '>' | '==' | '!=' | '>=' | '<=';
NOT_BITWISE: '~';
NOT_BOOLEAN: '!';
NODE: '$' ((IDENTIFIER (SLASH IDENTIFIER)*) | STRING);
LINE_COMMENT: '#' ~[\n]* -> channel(HIDDEN);
