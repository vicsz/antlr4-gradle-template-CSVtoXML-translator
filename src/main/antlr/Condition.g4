grammar Condition;

start : expr | <EOF> ;

expr : value operand value;

value : NUMBER | TAG;

operand : ' == ' ;

NUMBER : ('0' .. '9') + ('.' ('0' .. '9') +)? ;

TAG : [A-Z][A-Z0-9.]* ;
