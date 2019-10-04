grammar Script;

@header {package script.grammar;}

file: statement* EOF;
statement: new_var | new_const | assignment | invoke | function_declaration | for_statement | while_statement | class_statement | extends_statement | if_statement | elif_statement | else_statement | return_values | values;

new_var: (EXPORT list?)? ONREADY? VAR typed_id ASSIGN_SIGN values (SETGET IDENTIFIER COMMA IDENTIFIER)?;
new_const: CONST typed_id (COLON IDENTIFIER)? ASSIGN_SIGN values;
function_declaration: STATIC? FUNC IDENTIFIER list (ARROW type)? COLON;
for_statement: FOR values COLON;
while_statement: WHILE values COLON;
class_statement: CLASS IDENTIFIER COLON;
extends_statement: EXTENDS IDENTIFIER;
if_statement: IF values COLON;
elif_statement: ELIF values COLON;
else_statement: ELSE COLON;
assignment: values ASSIGN_SIGN values;
return_values: RETURN values;
invoke: IDENTIFIER list;
typed_id: IDENTIFIER (COLON type)?;
type: IDENTIFIER | TYPE_KEYWORD;
subscribe: IDENTIFIER array;
list: BRACE_LEFT values? (COMMA values)* BRACE_RIGHT;
array: BRACKET_LEFT values? (COMMA values)* BRACKET_RIGHT;
dictionary: PARENTHES_LEFT entry? (COMMA entry)* PARENTHES_RIGHT;
entry: (STRING | NUMBER | IDENTIFIER) (COLON | ASSIGN_SIGN) values;
values: value ((OPERATION_SIGN | OPERATION_KEYWORD | MINUS | DOT) value)*;
value: MINUS? (invoke | subscribe | subscribe | list | array | dictionary | (IDENTIFIER) | METADATA | NUMBER | STRING | VALUE_KEYWORD | MULTILINE_STRING | LINE_COMMENT);

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
ASSIGN_SIGN: '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=';
ARROW: '->';
OPERATION_SIGN: '~' | '*' | '/' | '%' | '+' | '<<' | '>>' | '&' | '^' | '|' | '<' | '>' | '==' | '!=' | '>=' | '<=' | '!' | '&&' | '||';
OPERATION_KEYWORD: 'not' | 'and' | 'or' | 'in' | 'is' | 'as';
TYPE_KEYWORD: 'bool' | 'int' | 'float';
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
