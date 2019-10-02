grammar Script;

file: primary* EOF;
primary: IDENTIFIER | KEYWORD | STRING | NUMBER | COMMA | DOT | OPERATOR_SIGN | BRACES | PARENTHESES | BRACKETS | COLON | LINE_COMMENT | BLOCK_COMMENT | NODE;

COMMA: ',';
DOT: '.';
COLON: ':';
BRACES: '{' | '}';
PARENTHESES: '(' | ')';
BRACKETS: '[' | ']';
KEYWORD: 'export' | 'onready' | 'var' | 'setget' | 'const' | 'static' | 'func' | 'for' | 'in' | 'is' | 'as' | 'while' | 'class' | 'extends' | 'class_name' | 'enum' | 'if' | 'elif' | 'else' | 'return' | 'not' | 'and' | 'or' | 'self' | 'true' | 'false' | 'null' | 'bool' | 'int' | 'float';
OPERATOR_SIGN: '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' | '~' | '*' | '/' | '%' | '+' | '-' | '<<' | '>>' | '&' | '^' | '|' | '<' | '>' | '==' | '!=' | '>=' | '<=' | '!' | '&&' | '||' | '->';

IDENTIFIER: [_a-zA-Z][_a-zA-Z0-9]*;
NODE: '$' [_a-zA-Z/]*;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
STRING: '"' (~["\n])* '"';
LINE_COMMENT: '#' ~[\r\n\f]*;
BLOCK_COMMENT: '"""' .*? '"""';
WHITESPACE: (' ' | [\t\n])+ -> channel(HIDDEN);

ERRCHAR: . -> channel(HIDDEN);
