grammar Condition;

start : expr | <EOF> ;

expr : NUMBER operand NUMBER;

operand : ' == ' ;

NUMBER : '1' ;
