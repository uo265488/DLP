grammar Cmm;	

program: ID*
       ;

ID: ([a-zA-Z] | '_') ([a-zA-Z] | '_' | DIGIT)* //is it mandatory the second part??
             ;

CHAR_CONSTANT: '\'' . '\''
            | '\'\\n\''
            | '\'\\t\''
            | ASCII_CHAR
            ;

ASCII_CHAR: '\'\\'INT_CONSTANT'\''
            ;

REAL_CONSTANT: FLOATING_POINT
            | MANTISSA_AND_EXPONENT
            ;

MANTISSA_AND_EXPONENT: FLOATING_POINT 'E' ('-'|'+') DIGIT+ //can it be exponent 0 ?????
                       | (FLOATING_POINT|INT_CONSTANT)+ 'e' DIGIT+
                       ;

FLOATING_POINT: INT_CONSTANT '.' DIGIT*
            | INT_CONSTANT? '.' DIGIT+
            ; //perfect (checked by Francisco)

INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;  //perfect
fragment
DIGIT: [0-9]
      ; //perfect

fragment
SKIP_CHARACTERS: ('\n'|'\t'|' '+) -> skip
                    ;

fragment
ONE_LINE_COMMENT: '//'.*?'\r'?('\n'|EOF) -> skip
                ;

fragment
MULTIPLE_LINE_COMMENT: '/*' .*? '*/' -> skip
                ;
