grammar Script;

import GeneratedLexer, Core;

@header {package gdscript;}

file: WHITESPACE* (line ((WHITESPACE | SEMICOLON)* line)*)? (WHITESPACE | SEMICOLON)* EOF;

line: var_line
    | const_line
    | func_line
    | enum_line
    | signal_line
    | extends_line
    | class_line
    | class_name_line
    | while_line
    | for_line
    | if_line
    | elif_line
    | match_line
    | return_line
    | label_line
    | else_line
    | PASS
    | BREAK
    | CONTINUE
    | TOOL
    | expression;

var_line: SYNC? (EXPORT (PARENTHES_OPEN arguments PARENTHES_CLOSE)?)? ONREADY? VAR IDENTIFIER (COLON type)? (EQUALS expression)? (SETGET IDENTIFIER? (COMMA IDENTIFIER)?)?;
const_line: CONST IDENTIFIER (COLON type)? EQUALS expression;
func_line: (STATIC | SYNC)? FUNC IDENTIFIER PARENTHES_OPEN func_argument? (COMMA func_argument)* COMMA? PARENTHES_CLOSE (ARROW type)? COLON;
func_argument: IDENTIFIER (COLON type)? (EQUALS expression)?;
enum_line: ENUM IDENTIFIER? BRACE_OPEN WHITESPACE* enum_argument (COMMA WHITESPACE* enum_argument)* COMMA? WHITESPACE* BRACE_CLOSE;
enum_argument: IDENTIFIER (EQUALS expression)? WHITESPACE*;
signal_line: SIGNAL IDENTIFIER (PARENTHES_OPEN arguments PARENTHES_CLOSE)?;
extends_line: EXTENDS (type | string) (DOT type)*;
class_line: CLASS IDENTIFIER (EXTENDS type)? COLON;
class_name_line: CLASS_NAME IDENTIFIER;
while_line: WHILE expression COLON;
for_line: FOR expression COLON;
if_line: IF expression COLON;
elif_line: ELIF expression COLON;
match_line: MATCH expression COLON;
return_line: RETURN expression?;
label_line: expression COLON;
else_line: ELSE COLON;

expression: primary (instance_field_expression | instance_method_expression | subscribe_expression | operator_expression)*;
instance_field_expression: DOT IDENTIFIER;
instance_method_expression: DOT invoke;
subscribe_expression: BRACKET_OPEN expression BRACKET_CLOSE;
operator_expression: (EQUALS | MINUS | OPERATOR | IS_AS_IN_AND_OR | IF | ELSE) primary;

primary: (MINUS | NOT | NOT_BITWISE | NOT_BOOLEAN)? (IDENTIFIER | FUNCTION_IDENTIFIER | CONSTANT_IDENTIFIER | CLASS_IDENTIFIER | NODE | TRUE_FALSE_SELF_NULL | NUMBER | string | array | dictionary | invoke | in_braces | type);
array: BRACKET_OPEN arguments BRACKET_CLOSE;
dictionary: BRACE_OPEN WHITESPACE* entry? (COMMA WHITESPACE* entry)* COMMA? WHITESPACE* BRACE_CLOSE;
entry: expression (COLON | EQUALS) expression WHITESPACE*;
invoke: DOT? (IDENTIFIER | FUNCTION_IDENTIFIER | CONSTANT_IDENTIFIER | CLASS_IDENTIFIER | BOOL_INT_FLOAT_VOID) PARENTHES_OPEN arguments PARENTHES_CLOSE;
in_braces: PARENTHES_OPEN expression PARENTHES_CLOSE;
arguments: WHITESPACE* expression? WHITESPACE* (COMMA WHITESPACE* expression)* COMMA? WHITESPACE*;
type: IDENTIFIER | CLASS_IDENTIFIER | BOOL_INT_FLOAT_VOID;
string: STRING_MULTILINE | STRING_DOUBLE_QUOTE | STRING_APHOSTROPHE | RESOURCE | USER_RESOURCE;

NUMBER: [+-]?([0-9]+([.][0-9]*)?|[.][0-9]+);
RESOURCE: '"res://' .*? '"';
USER_RESOURCE: '"user://' .*? '"';
STRING_MULTILINE: '"""' .*? '"""';
STRING_DOUBLE_QUOTE: '"' .*? ('"' | '\n' | EOF);
STRING_APHOSTROPHE: '\'' .*? ('\'' | '\n' | EOF);
SYNC: 'remote' | 'puppet' | 'master' | 'sync' | 'remotesync' | 'mastersync' | 'puppetsync';
MATCH: 'match';
EXPORT: 'export';
ONREADY: 'onready';
VAR: 'var';
SETGET: 'setget';
CONST: 'const';
STATIC: 'static';
FUNC: 'func';
FOR: 'for';
WHILE: 'while';
CLASS: 'class';
EXTENDS: 'extends';
CLASS_NAME: 'class_name';
ENUM: 'enum';
IF: 'if';
ELIF: 'elif';
ELSE: 'else';
RETURN: 'return';
PASS: 'pass';
TOOL: 'tool';
SIGNAL: 'signal';
BREAK: 'break';
CONTINUE: 'continue';
NOT: 'not';
IS_AS_IN_AND_OR: 'is' | 'as' | 'in' | 'and' | 'or';
TRUE_FALSE_SELF_NULL: 'true' | 'false' | 'self' | 'null';
BOOL_INT_FLOAT_VOID: 'bool' | 'int' | 'float' | 'void';
EQUALS: '=' | ':=';
SEMICOLON: ';';
COLON: ':';
COMMA: ',';
DOT: '.';
PARENTHES_OPEN: '(';
PARENTHES_CLOSE: ')';
BRACKET_OPEN: '[';
BRACKET_CLOSE: ']';
BRACE_OPEN: '{';
BRACE_CLOSE: '}';
ARROW: '->';
OPERATOR: '+' | '*' | '%' | '<<' | '>>' | '&' | '^' | '|' | '&&' | '||' | '/' | '<' | '>' | '==' | '!=' | '>=' | '<=' | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=';
MINUS: '-';
NOT_BITWISE: '~';
NOT_BOOLEAN: '!';
NODE: '$' ((IDENTIFIER ('/' IDENTIFIER)*) | STRING_DOUBLE_QUOTE);
