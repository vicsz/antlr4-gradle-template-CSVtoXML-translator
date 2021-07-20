grammar Condition;

start : expr EOF;

expr : expr OPERAND expr | value;

value : IDENTIFIER | NUMBER;

OPERAND : ' == ' | ' >= ' | ' <= ' | ' < ' | ' > ' ;

NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;

IDENTIFIER : [A-Z][A-Z0-9._]* ;
