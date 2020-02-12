grammar Script;

import GeneratedLexer, Core;

@header {package gdscript;}

file: WHITESPACE* (line ((WHITESPACE | SEMICOLON)* line)*)? (WHITESPACE | SEMICOLON)* EOF;

line: varLine
    | constLine
    | funcLine
    | enumLine
    | signalLine
    | extendsLine
    | classLine
    | classnameLine
    | whileLine
    | forLine
    | ifLine
    | elifLine
    | matchLine
    | returnLine
    | labelLine
    | elseLine
    | KEYWORD_FLOW
    | expression;

varLine: NETWORK_MODIFIER? (EXPORT (PARENTHES_OPEN arguments PARENTHES_CLOSE)?)? ONREADY? VAR IDENTIFIER (COLON type)? (EQUALS expression)? (SETGET IDENTIFIER? (COMMA IDENTIFIER)?)?;
constLine: CONST IDENTIFIER (COLON type)? EQUALS expression;
funcLine: NETWORK_MODIFIER? STATIC? FUNC IDENTIFIER PARENTHES_OPEN funcArg? (COMMA funcArg)* COMMA? PARENTHES_CLOSE (ARROW type)? COLON;
funcArg: IDENTIFIER (COLON type)? (EQUALS expression)?;
enumLine: ENUM IDENTIFIER? BRACE_OPEN WHITESPACE* enumArg (COMMA WHITESPACE* enumArg)* COMMA? WHITESPACE* BRACE_CLOSE;
enumArg: IDENTIFIER (EQUALS expression)? WHITESPACE*;
signalLine: SIGNAL IDENTIFIER (PARENTHES_OPEN arguments PARENTHES_CLOSE)?;
extendsLine: EXTENDS (type | string) (DOT type)*;
classLine: CLASS IDENTIFIER (EXTENDS type)? COLON;
classnameLine: CLASS_NAME IDENTIFIER;
whileLine: WHILE expression COLON;
forLine: FOR expression COLON;
ifLine: IF expression COLON;
elifLine: ELIF expression COLON;
matchLine: MATCH expression COLON;
returnLine: RETURN expression?;
labelLine: expression COLON;
elseLine: ELSE COLON;

expression: primary (subscribe | instanceField | instanceMethod | operator | castOperator)*;
subscribe: BRACKET_OPEN expression BRACKET_CLOSE;
instanceField: DOT IDENTIFIER;
instanceMethod: DOT invoke;
operator: (EQUALS | MINUS | OPERATOR | KEYWORD_OPERATOR | IF | ELSE) primary;
castOperator: CAST_OPERATOR type;

primary: (MINUS | NOT | NOT_BITWISE | NOT_BOOLEAN)? (IDENTIFIER | FUNCTION_IDENTIFIER | CONSTANT_IDENTIFIER | CLASS_IDENTIFIER | NODE | KEYWORD_VALUE | NUMBER | string | array | dictionary | invoke | inBraces | type);
array: BRACKET_OPEN arguments BRACKET_CLOSE;
dictionary: BRACE_OPEN WHITESPACE* entry? (COMMA WHITESPACE* entry)* COMMA? WHITESPACE* BRACE_CLOSE;
entry: expression (COLON | EQUALS) expression WHITESPACE*;
invoke: DOT? (IDENTIFIER | FUNCTION_IDENTIFIER | CONSTANT_IDENTIFIER | CLASS_IDENTIFIER | PRIMITIVE) PARENTHES_OPEN arguments PARENTHES_CLOSE;
inBraces: PARENTHES_OPEN expression PARENTHES_CLOSE;
arguments: WHITESPACE* expression? WHITESPACE* (COMMA WHITESPACE* expression)* COMMA? WHITESPACE*;
type: IDENTIFIER | CLASS_IDENTIFIER | PRIMITIVE;
string: STRING | RESOURCE | USER_RESOURCE;

NUMBER: [+-]?([0-9]+([.][0-9]*)?|[.][0-9]+);
RESOURCE: '"res://' .*? '"';
USER_RESOURCE: '"user://' .*? '"';
STRING: ('"""' .*? '"""') | ('"' .*? ('"' | '\n' | EOF)) | ('\'' .*? ('\'' | '\n' | EOF));
NODE: '$' ((IDENTIFIER ('/' IDENTIFIER)*) | STRING);
NETWORK_MODIFIER: 'remote' | 'puppet' | 'master' | 'sync' | 'remotesync' | 'mastersync' | 'puppetsync';
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
SIGNAL: 'signal';
NOT: 'not';
KEYWORD_FLOW: 'pass' | 'break' | 'continue' | 'tool';
KEYWORD_OPERATOR: 'in' | 'and' | 'or';
CAST_OPERATOR: 'is' | 'as';
KEYWORD_VALUE: 'true' | 'false' | 'self' | 'null';
PRIMITIVE: 'bool' | 'int' | 'float' | 'void';
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
