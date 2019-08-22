grammar GDScript;

file: (line | expr | NL)+ EOF;

line: var_line | func_line | class_line | extends_line | class_name_line | enum_line | if_line | elif_line | else_line | return_line | func_invoke_expr | dictionary_expr;

var_line: (EXPORT ('(' expr? (',' expr)* ')')?)? ONREADY? VAR IDENTIFIER (':' IDENTIFIER)? ('=' expr)? (SETGET IDENTIFIER? (',' IDENTIFIER)?)?;
EXPORT: 'export';
ONREADY: 'onready';
VAR: 'var';
SETGET: 'setget';

func_line: STATIC? FUNC IDENTIFIER '(' expr? (',' expr)* ')' ('->' IDENTIFIER)? ':';
STATIC: 'static';
FUNC: 'func';

class_line: CLASS IDENTIFIER ':';
CLASS: 'class';

extends_line: EXTENDS (IDENTIFIER | STRING);
EXTENDS: 'extends';

class_name_line: CLASS_NAME IDENTIFIER (',' STRING)?;
CLASS_NAME: 'class_name';

enum_line: ENUM IDENTIFIER? dictionary_expr;
ENUM: 'enum';

if_line: IF expr ':';
IF: 'if';

elif_line: ELIF expr ':';
ELIF: 'elif';

else_line: ELSE ':';
ELSE: 'else';

return_line: RETURN expr;
RETURN: 'return';

expr: IDENTIFIER | NUMBER | STRING | LINE_COMMENT | BLOCK_COMMENT | func_invoke_expr | dictionary_expr;

func_invoke_expr: IDENTIFIER '(' expr? (',' expr)* ')';

dictionary_expr: '{' expr? (',' expr)* '}';

IDENTIFIER: [_a-zA-Z0-9]+;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
STRING: '"' (~["\n])* '"';
LINE_COMMENT: '#' ~[\r\n\f]*;
BLOCK_COMMENT: '"""' .*? '"""';
NL: '\n';
WHITESPACE: ' '+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
