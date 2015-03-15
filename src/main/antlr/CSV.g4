grammar CSV;

file: header row+ ;
header: TEXT (',' TEXT)* '\r'? '\n' ;
row: TEXT (',' TEXT)* '\r'? '\n' ;
TEXT: ~[,\n\r"]+ ;