grammar Resource;

import Core;

file: (statement | NL)* EOF;
statement: section | entry | LINE_COMMENT;
section: BRACKET_LEFT (section_id | entry)+ BRACKET_RIGHT;
entry: id ('/' id)* '=' value;
section_id: id (DOT id)*;
value: STRING | NUMBER | KEYWORD | constructor | list | dictionary;
constructor: IDENTIFIER PARENTHES_LEFT value? (COMMA value)* PARENTHES_RIGHT;
list: BRACKET_LEFT value? (COMMA value)* BRACKET_RIGHT;
dictionary: BRACE_LEFT NL* dictionary_entry? (COMMA dictionary_entry)* NL* BRACE_RIGHT;
dictionary_entry: STRING COLON value;
id: IDENTIFIER | NUMBER;

KEYWORD: 'true' | 'false';
LINE_COMMENT: ';' ~[\n]*;
