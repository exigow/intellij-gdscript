grammar Resource;

import Keyword, Core;

file: (statement | NL)* EOF;
statement: section | property | LINE_COMMENT;
section: BRACKET_LEFT (section_id | property)+ BRACKET_RIGHT;
property: key '=' value;
key: id ((SLASH | DOT) id)*;
section_id: id (DOT id)*;
value: IDENTIFIER | STRING | NUMBER | TRUE | FALSE | NULL | constructor | list | dictionary | entry;
constructor: IDENTIFIER PARENTHES_LEFT NL* value? (COMMA NL* value)* NL* PARENTHES_RIGHT;
list: BRACKET_LEFT NL* value? (COMMA NL* value)* NL* BRACKET_RIGHT;
dictionary: BRACE_LEFT NL* entry? (COMMA NL* entry)* NL* BRACE_RIGHT;
entry: STRING COLON value;
id: IDENTIFIER | NUMBER;

LINE_COMMENT: SEMICOLON ~[\n]*;
