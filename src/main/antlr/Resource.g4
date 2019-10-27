grammar Resource;

import Core;

file: (statement | NL)* EOF;

statement: section | entry;

section: '[' (IDENTIFIER | entry)+ ']';
entry: IDENTIFIER '=' value;
value: STRING | NUMBER | KEYWORD | constructor | list | dictionary;
constructor: IDENTIFIER '(' value? (',' value)* ')';
list: '[' value? (',' value)* ']';
dictionary: '{' NL* dictionary_entry? (',' dictionary_entry)* NL* '}';
dictionary_entry: STRING ':' value;

KEYWORD: 'true' | 'false';
IDENTIFIER: ('_' | LOWER_CASE | UPPER_CASE) [._/a-zA-Z0-9]*;
STRING: '"' .*? '"';
NUMBER: [-.0-9]+;
LINE_COMMENT: ';' ~[\n]*;
