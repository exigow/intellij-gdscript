grammar Script;

@header {package script.grammar;}

file: statement* EOF;
statement: var_statement | const_statement | assign_statement | function_statement | invoke_statement | for_statement | while_statement | class_statement | extends_statement | class_name_statement | enum_statement | if_statement | elif_statement | else_statement | return_statement | pass_statement | signal_statement | value_with_operators_statement;

var_statement: EXPORT? list? ONREADY? VAR typed_id (ASSIGN_SIGN value_with_operators_statement)? SETGET? IDENTIFIER? COMMA? IDENTIFIER?;
const_statement: CONST typed_id (COLON IDENTIFIER)? ASSIGN_SIGN value_with_operators_statement;
assign_statement: value_with_operators_statement ASSIGN_SIGN value_with_operators_statement;
function_statement: STATIC? FUNC invoke_statement (ARROW IDENTIFIER)? COLON;
invoke_statement: IDENTIFIER list;
for_statement: FOR value_with_operators_statement COLON;
while_statement: WHILE value_with_operators_statement COLON;
class_statement: CLASS IDENTIFIER COLON;
extends_statement: EXTENDS IDENTIFIER;
class_name_statement: CLASS_NAME IDENTIFIER;
enum_statement: ENUM IDENTIFIER? dictionary;
if_statement: IF value_with_operators_statement COLON;
elif_statement: ELIF value_with_operators_statement COLON;
else_statement: ELSE COLON;
return_statement: RETURN value_with_operators_statement;
pass_statement: PASS;
signal_statement: SIGNAL IDENTIFIER;
value_with_operators_statement: value ((OPERATION_SIGN | OPERATION_KEYWORD | MINUS | DOT) value)*;

typed_id: IDENTIFIER (COLON IDENTIFIER)?;
subscribe: IDENTIFIER array;
list: BRACE_LEFT value_with_operators_statement? (COMMA value_with_operators_statement)* BRACE_RIGHT;
array: BRACKET_LEFT value_with_operators_statement? (COMMA value_with_operators_statement)* BRACKET_RIGHT;
dictionary: PARENTHES_LEFT dictionary_entry? (COMMA dictionary_entry)* PARENTHES_RIGHT;
dictionary_entry: (STRING | NUMBER | IDENTIFIER) ((COLON | ASSIGN_SIGN) value_with_operators_statement)?;
value: (MINUS | NOT_KEYWORD)? (subscribe | invoke_statement | list | array | dictionary | typed_id | METADATA | NUMBER | STRING | VALUE_KEYWORD | MULTILINE_STRING | LINE_COMMENT);

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
