grammar Script;

@header {package script.grammar;}

file: statement* EOF;
statement: var_statement | const_statement | assign_statement | function_statement | invoke_statement | for_statement | while_statement | class_statement | extends_statement | class_name_statement | enum_statement | if_statement | elif_statement | else_statement | return_statement | pass_statement | signal_statement | chain;

var_statement: EXPORT? list? ONREADY? VAR IDENTIFIER (COLON type)? (ASSIGN_SIGN chain)? SETGET? IDENTIFIER? COMMA? IDENTIFIER?;
const_statement: CONST IDENTIFIER (COLON type)? ASSIGN_SIGN chain;
assign_statement: chain ASSIGN_SIGN chain;
function_statement: STATIC? FUNC IDENTIFIER list (ARROW type)? COLON;
invoke_statement: IDENTIFIER list;
for_statement: FOR chain COLON;
while_statement: WHILE chain COLON;
class_statement: CLASS IDENTIFIER COLON;
extends_statement: EXTENDS IDENTIFIER;
class_name_statement: CLASS_NAME IDENTIFIER;
enum_statement: ENUM IDENTIFIER? dictionary;
if_statement: IF chain COLON;
elif_statement: ELIF chain COLON;
else_statement: ELSE COLON;
return_statement: RETURN chain;
pass_statement: PASS;
signal_statement: SIGNAL IDENTIFIER;
chain: value ((OPERATION_SIGN | OPERATION_KEYWORD | MINUS | DOT) value)*;

subscribe: IDENTIFIER array;
list: BRACE_LEFT chain? (COMMA chain)* BRACE_RIGHT;
array: BRACKET_LEFT chain? (COMMA chain)* BRACKET_RIGHT;
dictionary: PARENTHES_LEFT dictionary_entry? (COMMA dictionary_entry)* PARENTHES_RIGHT;
dictionary_entry: (STRING | NUMBER | IDENTIFIER) ((COLON | ASSIGN_SIGN) chain)?;
typed_argument: IDENTIFIER (COLON type);
type: IDENTIFIER | PRIMITIVE_KEYWORD;
value: (MINUS | NOT_KEYWORD)? (subscribe | invoke_statement | list | array | dictionary | typed_argument | type | METADATA | NUMBER | STRING | VALUE_KEYWORD | MULTILINE_STRING | LINE_COMMENT);

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
SIGNAL: 'signal';
ASSIGN_SIGN: '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=';
ARROW: '->';
OPERATION_SIGN: '~' | '*' | '/' | '%' | '+' | '<<' | '>>' | '&' | '^' | '|' | '<' | '>' | '==' | '!=' | '>=' | '<=' | '!' | '&&' | '||';
OPERATION_KEYWORD: 'and' | 'or' | 'in' | 'is' | 'as';
NOT_KEYWORD: 'not';
VALUE_KEYWORD: 'self' | 'null' | 'true' | 'false';
PRIMITIVE_KEYWORD: 'bool' | 'int' | 'float' | 'void';

COMMA: ',';
DOT: '.';
COLON: ':';
BRACE_LEFT: '(';
BRACE_RIGHT: ')';
BRACKET_LEFT: '[';
BRACKET_RIGHT: ']';
PARENTHES_LEFT: '{';
PARENTHES_RIGHT: '}';
IDENTIFIER: IDENTIFIER_START (IDENTIFIER_START | DIGIT)*;
METADATA: '$' (LOWER_CASE | UPPER_CASE | '/')*;
MINUS: '-';
NUMBER: MINUS? DIGIT+ ('.' DIGIT+)?;
STRING: '"' (~["\n])* '"';
MULTILINE_STRING: '"""' .*? '"""';
LINE_COMMENT: '#' ~[\r\n\f]*;
fragment IDENTIFIER_START: LOWER_CASE | UPPER_CASE | '_';
fragment LOWER_CASE: 'a'..'z';
fragment UPPER_CASE: 'A'..'Z';
fragment DIGIT: '0'..'9';

WHITESPACE: (' ' | [\t\n])+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
