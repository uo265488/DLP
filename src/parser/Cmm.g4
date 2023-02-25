grammar Cmm;	

program: definition+
       ;

definition: varDefinition ';'
        | type '{' (varDefinition ';')* (statement)* '}'
        ;

statement: functionInvocation ';'
        | 'return' expression ';' //return
        | 'if' '(' expression ')' block ('else' block)? //if else | is it OK???
        | 'while' '(' expression ')' block //while
        | expression '=' expression ';' //assignment
        | 'write' expression (',' expression)* ';'
        | 'input' expression (',' expression)* ';'
        ;

block: statement
    | '{' statement+ '}'
    ;

expression: functionInvocation               //checked by Ortin
            | expression '[' expression ']'
            | expression '.' ID
            | '(' type ')' expression //cast
            | '-' expression //unary minus
            | '!' expression //unary not
            | expression ('*'|'/'|'%') expression //arithmetic and modulus
            | expression ('+'|'-') expression //arithmetic
            | expression ('>' | '>=' | '<' | '<=' | '!=' | '==') expression //comparison
            | expression ('&&'|'||') expression // logic
            | ID  //Variable
            | INT_CONSTANT //Int_literal
            | REAL_CONSTANT //Double_literal
            | CHAR_CONSTANT //Char_literal
            ;

type: 'struct' '{' recordFields '}'
    | type ID '(' arguments? ')'
    | type '[' INT_CONSTANT ']' //array type
    | 'int'
    | 'double'
    | 'char'
    | 'void'
    ;

recordFields: (type ID ';')* //is the syntax "char f, i, g;" accepted in recordfields???
    ;

functionInvocation: ID '(' parameters? ')'
                    ;

parameters: expression (',' expression)*
    ;

arguments: (varDefinition) (',' varDefinition)*
    ;

varDefinition: type ID (',' ID)*  //the UML is uncompleted (missing relation with variable)
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

SKIP_CHARACTERS: ('\n'|'\t'|' '|'\r'+) -> skip
                    ;

ONE_LINE_COMMENT: '//'.*?'\r'?('\n'|EOF) -> skip
                ;

MULTIPLE_LINE_COMMENT: '/*' .*? '*/' -> skip
                ;
