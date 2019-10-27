grammar Resource;

import Keyword, Core;

file: (statement | NL)* EOF;
statement: section | entry | LINE_COMMENT;
section: BRACKET_LEFT (section_id | entry)+ BRACKET_RIGHT;
entry: id (SLASH id)* '=' value;
section_id: id (DOT id)*;
value: STRING | NUMBER | TRUE | FALSE | constructor | list | dictionary;
constructor: IDENTIFIER PARENTHES_LEFT NL* value? (COMMA NL* value)* NL* PARENTHES_RIGHT;
list: BRACKET_LEFT NL* value? (COMMA NL* value)* NL* BRACKET_RIGHT;
dictionary: BRACE_LEFT NL* dictionary_entry? (COMMA NL* dictionary_entry)* NL* BRACE_RIGHT;
dictionary_entry: STRING COLON value;
id: IDENTIFIER | NUMBER;

LINE_COMMENT: SEMICOLON ~[\n]*;
