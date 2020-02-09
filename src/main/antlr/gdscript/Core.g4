lexer grammar Core;

IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;
LINE_COMMENT: '#' ~[\n]* -> channel(HIDDEN);
WHITESPACE: (' ' | '\t' | '\n' | '\r')+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
