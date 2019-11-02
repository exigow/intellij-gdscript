lexer grammar CoreLexer;

EQUALS: '=';
MINUS: '-';
SEMICOLON: ';';
SLASH: '/';
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
fragment NUMBER_FLOATING: DIGIT+ DOT? (DIGIT+)? ('e' ('-' | '+')? DIGIT+)?;
fragment NUMBER_BINARY: '0b' ('0' | '1')+;
fragment NUMBER_HEXADECIMAL: '0x' (DIGIT | 'A'..'F')+;

IDENTIFIER: DIGIT* LETTER (LETTER | DIGIT)*;
fragment LETTER: LOWER_CASE | UPPER_CASE | UNDERSCORE;
fragment LOWER_CASE: 'a'..'z';
fragment UPPER_CASE: 'A'..'Z';
fragment UNDERSCORE: '_';
fragment DIGIT: '0'..'9';

RESOURCE: '"' ('res' | 'user') '://' .*? '"';

STRING_MULTILINE: '"""' .*? '"""';
STRING_DOUBLE_QUOTE: '"' .*? ('"' | NL | EOF);
STRING_APHOSTROPHE: '\'' .*? ('\'' | NL | EOF);

WHITESPACE: (' ' | '\t')+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
