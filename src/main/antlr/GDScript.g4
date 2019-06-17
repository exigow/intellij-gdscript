grammar GDScript;

script: statement* EOF;

statement:
    IF '(' expression ')' statement |
    IDENTIFIER '=' expression |
    call_function_expression;

expression:
    expression operator expression |
    '-' expression |
    call_function_expression |
    '(' expression ')' |
    primary;

operator: '*' | '/' | '+' | '-' | '==';

call_function_expression: IDENTIFIER '(' ')';

primary: IDENTIFIER | NUMBER | STRING;

IF: 'if';
IDENTIFIER: [a-zA-Z]+;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
STRING: '"' .*? '"';
LINE_COMMENT: '#' .*? ('\n' | EOF) -> channel(HIDDEN);
WHITE_SPACE: [ \t\n\r]+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);
