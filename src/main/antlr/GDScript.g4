grammar GDScript;

// keywords
IF: 'if';
ELSE: 'else';
WHILE: 'while';
VARIABLE: 'var';
CONSTANT: 'const';
RETURN: 'return';
FUNCTION: 'func';

IDENTIFIER: [a-zA-Z_] [a-zA-Z0-9_]*;
NUMBER: '-'? [0-9]+ ('.' [0-9]+)?;
STRING: '"' .*? '"';
LINE_COMMENT: '#' .*? ('\n' | EOF) -> channel(HIDDEN);
WS: [ \t\n\r]+ -> channel(HIDDEN);
ERRCHAR: . -> channel(HIDDEN);

script:	variable_definition* statement* EOF;

variable_definition : (VARIABLE | CONSTANT) IDENTIFIER '=' expression;

statement:
    WHILE '(' expression ')' statement |
    IF '(' expression ')' statement (ELSE statement)? |
    IDENTIFIER '=' expression |
    call_function_expression |
    RETURN expression;

expression:
    expression operator expression |
    '-' expression |
    call_function_expression |
    '(' expression ')' |
    primary;

operator: '*' | '/' | '+' | '-' | '==';

call_function_expression: IDENTIFIER '(' call_function_arguments_expression? ')';

call_function_arguments_expression : expression (',' expression)*;

primary: IDENTIFIER | NUMBER | STRING;
