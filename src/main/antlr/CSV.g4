grammar CSV;

file: header row+ ;
header : field (',' field)* '\r'? '\n' ;

row : field (',' field)* '\r'? '\n' ;

field
    : TEXT
    | STRING
    |
    ;

TEXT   : ~[,\n\r"]+ ;
STRING : '"' ('""'|~'"')* '"' ; // quote-quote is an escaped quote