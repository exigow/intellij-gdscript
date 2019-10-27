lexer grammar Core;

COLON: ':';
COMMA: ',';
DOT: '.';
PARENTHES_LEFT: '(';
PARENTHES_RIGHT: ')';
BRACKET_LEFT: '[';
BRACKET_RIGHT: ']';
BRACE_LEFT: '{';
BRACE_RIGHT: '}';
NL: '\n';

NUMBER: NUMBER_FLOATING | NUMBER_BINARY | NUMBER_HEXADECIMAL;
fragment NUMBER_FLOATING: DIGIT+ DOT? (DIGIT+)? ('e' '-'? DIGIT+)?;
fragment NUMBER_BINARY: '0b' ('0' | '1')+;
fragment NUMBER_HEXADECIMAL: '0x' (DIGIT | 'A'..'F')+;

IDENTIFIER: (LOWER_CASE | UPPER_CASE | UNDERSCORE) (LOWER_CASE | UPPER_CASE | UNDERSCORE | DIGIT)*;
fragment LOWER_CASE: 'a'..'z';
fragment UPPER_CASE: 'A'..'Z';
fragment UNDERSCORE: '_';
fragment DIGIT: '0'..'9';

WHITESPACE: (' ' | '\t')+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);