grammar GDScript;

file: (line | LINE_COMMENT | BLOCK_COMMENT | NL)+ EOF;

line: var_line 
    | const_line
    | func_line
    | for_line
    | while_line
    | class_line
    | extends_line
    | class_name_line
    | enum_line
    | if_line
    | elif_line
    | else_line
    | return_line
    | func_invoke_expr;

var_line: (EXPORT ('(' expr? (',' expr)* ')')?)? ONREADY? VAR IDENTIFIER (':' IDENTIFIER)? ('=' expr)? (SETGET IDENTIFIER? (',' IDENTIFIER)?)?;
EXPORT: 'export';
ONREADY: 'onready';
VAR: 'var';
SETGET: 'setget';

const_line: CONST IDENTIFIER (':' IDENTIFIER)? '=' expr;
CONST: 'const';

func_line: STATIC? FUNC IDENTIFIER '(' expr? (',' expr)* ')' ('->' IDENTIFIER)? ':';
STATIC: 'static';
FUNC: 'func';

for_line: FOR IDENTIFIER IN expr ':';
FOR: 'for';
IN: 'in';

while_line: WHILE expr ':';
WHILE: 'while';

class_line: CLASS IDENTIFIER ':';
CLASS: 'class';

extends_line: EXTENDS (IDENTIFIER);
EXTENDS: 'extends';

class_name_line: CLASS_NAME IDENTIFIER (',' STRING)?;
CLASS_NAME: 'class_name';

enum_line: ENUM IDENTIFIER? '{' expr? (',' expr)* '}';
ENUM: 'enum';

if_line: IF expr ':';
IF: 'if';

elif_line: ELIF expr ':';
ELIF: 'elif';

else_line: ELSE ':';
ELSE: 'else';

return_line: RETURN expr;
RETURN: 'return';

expr: IDENTIFIER | NUMBER | STRING | func_invoke_expr;

func_invoke_expr: IDENTIFIER '(' expr? (',' expr)* ')';

IDENTIFIER: [_a-zA-Z][_a-zA-Z0-9]*;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
STRING: '"' (~["\n])* '"';
LINE_COMMENT: '#' ~[\r\n\f]*;
BLOCK_COMMENT: '"""' .*? '"""';
NL: '\n';
WHITESPACE: ' '+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
