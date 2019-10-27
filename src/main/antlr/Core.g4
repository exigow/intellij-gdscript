lexer grammar Core;

LOWER_CASE: 'a'..'z';
UPPER_CASE: 'A'..'Z';
DIGIT: '0'..'9';
NL: '\n';
WHITESPACE: (' ' | '\t')+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
