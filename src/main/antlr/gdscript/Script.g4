grammar Script;

import GeneratedLexer, Core;

file: separator* (line (separator+ line?)*)? EOF;

separator: NL | SEMICOLON | COLON;

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
    | else_line
    | pass_line
    | break_line
    | continue_line
    | tool_line
    | expression;

var_line: (PUPPET | MASTER)? (EXPORT (PARENTHES_LEFT arguments PARENTHES_RIGHT)?)? ONREADY? VAR IDENTIFIER (COLON type)? ((EQUALS | INFER) expression)? (SETGET IDENTIFIER? (COMMA IDENTIFIER)?)?;
const_line: CONST IDENTIFIER (COLON type)? (EQUALS | INFER) expression;
func_line: (STATIC | PUPPET | MASTER | SYNC | REMOTE)? FUNC IDENTIFIER PARENTHES_LEFT func_argument? (COMMA func_argument)* PARENTHES_RIGHT (ARROW type)?;
func_argument: IDENTIFIER (COLON type)? ((EQUALS | INFER) expression)?;
enum_line: ENUM IDENTIFIER? BRACE_LEFT NL* enum_argument (COMMA NL* enum_argument)* BRACE_RIGHT;
enum_argument: IDENTIFIER (EQUALS expression)? NL*;
signal_line: SIGNAL IDENTIFIER (PARENTHES_LEFT arguments PARENTHES_RIGHT)?;
extends_line: EXTENDS (type | string) (DOT type)*;
class_line: CLASS IDENTIFIER (EXTENDS type)?;
class_name_line: CLASS_NAME IDENTIFIER;
while_line: WHILE expression;
for_line: FOR expression;
if_line: IF expression;
elif_line: ELIF expression;
match_line: MATCH expression;
return_line: RETURN expression?;
else_line: ELSE;
pass_line: PASS;
break_line: BREAK;
continue_line: CONTINUE;
tool_line: TOOL;

expression: primary (instance_field_expression | instance_method_expression | type_operator_expression | subscribe_expression | operator_expression)*;
instance_field_expression: DOT IDENTIFIER;
instance_method_expression: DOT invoke;
type_operator_expression: (AS | IS) primary;
subscribe_expression: BRACKET_LEFT expression BRACKET_RIGHT;
operator_expression: (EQUALS | INFER | ASSIGN | MINUS | OTHER_OPERATORS | SLASH | COMPARE | AND | OR | IN | IF | ELSE) primary;

primary: (MINUS | NOT | NOT_BITWISE | NOT_BOOLEAN)? (IDENTIFIER | FUNCTION_IDENTIFIER | CONSTANT_IDENTIFIER | CLASS_IDENTIFIER | NODE | TRUE | FALSE | SELF | NULL | NUMBER | string | array | dictionary | invoke | in_braces | type);
array: BRACKET_LEFT arguments BRACKET_RIGHT;
dictionary: BRACE_LEFT NL* entry? (COMMA NL* entry)* BRACE_RIGHT;
entry: expression (COLON | EQUALS) expression NL*;
invoke: DOT? (IDENTIFIER | FUNCTION_IDENTIFIER | CONSTANT_IDENTIFIER | CLASS_IDENTIFIER | primitive) PARENTHES_LEFT arguments PARENTHES_RIGHT;
in_braces: PARENTHES_LEFT expression PARENTHES_RIGHT;
arguments: NL* expression? NL* (COMMA NL* expression)* NL*;
type: IDENTIFIER | CLASS_IDENTIFIER | primitive;
primitive: BOOL | INT | FLOAT | VOID;
string: STRING_MULTILINE | STRING_DOUBLE_QUOTE | STRING_APHOSTROPHE | RESOURCE | USER_RESOURCE;

REMOTE: 'remote';
PUPPET: 'puppet';
MASTER: 'master';
SYNC: 'sync';
REMOTESYNC: 'remotesync';
MASTERSYNC: 'mastersync';
PUPPETSYNC: 'puppetsync';
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
AND: 'and';
OR: 'or';
IN: 'in';
IS: 'is';
AS: 'as';
SELF: 'self';
NULL: 'null';
TRUE: 'true';
FALSE: 'false';
BOOL: 'bool';
INT: 'int';
FLOAT: 'float';
VOID: 'void';
ASSIGN: '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=';
INFER: ':=';
ARROW: '->';
OTHER_OPERATORS: '+' | '*' | '%' | '<<' | '>>' | '&' | '^' | '|' | '&&' | '||';
COMPARE: '<' | '>' | '==' | '!=' | '>=' | '<=';
NOT_BITWISE: '~';
NOT_BOOLEAN: '!';
NODE: '$' ((IDENTIFIER (SLASH IDENTIFIER)*) | STRING_DOUBLE_QUOTE);
LINE_COMMENT: '#' ~[\n]* -> channel(HIDDEN);
