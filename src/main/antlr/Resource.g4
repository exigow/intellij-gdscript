grammar Resource;

import CoreLexer;

file: (statement | NL)* EOF;
statement: section | property | LINE_COMMENT;
section: BRACKET_LEFT (section_id | property)+ BRACKET_RIGHT;
property: key EQUALS value;
key: id ((SLASH | DOT) id)*;
section_id: id (DOT id)*;
value: MINUS? (IDENTIFIER | NUMBER | TRUE | FALSE | NULL | string | constructor | list | dictionary | entry);
constructor: IDENTIFIER PARENTHES_LEFT NL* value? NL* (COMMA NL* value NL*)* NL* PARENTHES_RIGHT;
list: BRACKET_LEFT NL* value? NL* (COMMA NL* value NL*)* NL* BRACKET_RIGHT;
dictionary: BRACE_LEFT NL* entry? (COMMA NL* entry NL*)* NL* BRACE_RIGHT;
entry: string COLON value;
id: IDENTIFIER | NUMBER;
string: STRING_MULTILINE | STRING_DOUBLE_QUOTE | STRING_APHOSTROPHE | RESOURCE;

TRUE: 'true';
FALSE: 'false';
NULL: 'null';
LINE_COMMENT: SEMICOLON ~[\n]*;
