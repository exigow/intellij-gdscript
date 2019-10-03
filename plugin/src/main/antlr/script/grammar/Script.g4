grammar Script;

@header {package script.grammar;}

file: expression* EOF;
expression: KEYWORD | OPERATION_SIGN | COMMA | DOT | COLON | IDENTIFIER | METADATA | NUMBER | STRING | MULTILINE_STRING | LINE_COMMENT | list | array | dictionary;
list: BRACE_LEFT expression* BRACE_RIGHT;
array: BRACKET_LEFT expression* BRACKET_RIGHT;
dictionary: PARENTHES_LEFT expression* PARENTHES_RIGHT;

KEYWORD: 'export' | 'onready' | 'var' | 'setget' | 'const' | 'static' | 'func' | 'for' | 'in' | 'is' | 'as' | 'while' | 'class' | 'extends' | 'class_name' | 'enum' | 'if' | 'elif' | 'else' | 'return' | 'not' | 'and' | 'or' | 'self' | 'true' | 'false' | 'null' | 'bool' | 'int' | 'float';
OPERATION_SIGN: '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' | '~' | '*' | '/' | '%' | '+' | '-' | '<<' | '>>' | '&' | '^' | '|' | '<' | '>' | '==' | '!=' | '>=' | '<=' | '!' | '&&' | '||' | '->';
COMMA: ',';
DOT: '.';
COLON: ':';
BRACE_LEFT: '(';
BRACE_RIGHT: ')';
BRACKET_LEFT: '[';
BRACKET_RIGHT: ']';
PARENTHES_LEFT: '{';
PARENTHES_RIGHT: '}';

IDENTIFIER: [_a-zA-Z][_a-zA-Z0-9]*;
METADATA: '$' [_a-zA-Z/]*;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
STRING: '"' (~["\n])* '"';
MULTILINE_STRING: '"""' .*? '"""';
LINE_COMMENT: '#' ~[\r\n\f]*;
WHITESPACE: (' ' | [\t\n])+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
