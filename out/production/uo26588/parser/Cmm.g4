grammar Cmm;

@header {
import ast.*;
import ast.definition.*;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;
}

program returns [Program ast] locals [List<Definition> defs = new ArrayList<Definition>();]:
       (d=definition { $d.ast.stream().forEach(temp ->
                                           $defs.add(temp));    })* main EOF { $defs.add($main.ast); }
       { $ast = new Program(0,0, $defs); }

       ;

main returns [FunctionDefinition ast] locals [List<Statement> sts = new ArrayList<Statement>()]:

    'void' 'main''('')' '{'
    (v=varDefinition { $sts.addAll($v.ast); } ';')+
    (s=statement { $sts.addAll($s.ast); })+ '}'

    { $ast = new FunctionDefinition($v.ast.get(0).getLine(),
                                    $v.ast.get(0).getColumn(),
                                    new FunctionType($v.ast.get(0).getLine(),
                                                     $v.ast.get(0).getColumn(),
                                                     new VoidType($v.ast.get(0).getLine(), $v.ast.get(0).getColumn()),
                                                     new ArrayList<VarDefinition>()),

                                    "main",
                                    $sts); }

    ;

definition returns [List<Definition> ast = new ArrayList<Definition>()]:
          v=varDefinition ';' { $v.ast.stream().forEach(
                                        temp -> $ast.add(new VarDefinition(temp.getLine(), temp.getColumn(), temp.type, temp.name))); }
        | functionDefinition
        { $ast.add($functionDefinition.ast); }
        ;

functionDefinition returns [FunctionDefinition ast] locals [List<Statement> sts = new ArrayList<Statement>()]:

    t=returnType ID '(' a=arguments ')' '{' (v=varDefinition { $sts.addAll($v.ast); } ';')* (s=statement { $sts.addAll($s.ast); })* '}'
    { $ast = new FunctionDefinition($t.ast.getLine(),
                                    $t.ast.getColumn(),
                                    new FunctionType($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $a.ast),
                                    $ID.text,
                                    $sts); }
    ;

statement returns [List<Statement> ast = new ArrayList<Statement>()]:
         f=functionInvocation ';' { $ast.add($f.ast); }
        | 'return' e1=expression ';' { $ast.add(new Return($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast)); } //return
        | ifElse { $ast.add($ifElse.ast); } //if else | is it OK???
        | 'while' '(' e1=expression ')' b1=block //while
        { $ast.add(new While($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast)); }
        | e1=expression '=' e2=expression ';' { $ast.add(new Assignment($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast)); }//assignment
        | 'write' e1=expression { $ast.add(new Input($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast)); }
          (',' e2=expression { $ast.add(new Input($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast)); } )* ';'
        | 'read' e1=expression { $ast.add(new Print($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast)); }
          (',' e2=expression { $ast.add(new Print($e2.ast.getLine(), $e2.ast.getColumn(), $e2.ast)); })* ';'
        /* VAR DEFINITION ??????*/
        ;

ifElse returns [Statement ast]:
    'if' '(' e1=expression ')' b1=block { $ast = new IfElse($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast); }
    | 'if' '(' e1=expression ')' b1=block 'else' b2=block { $ast = new IfElse($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $b1.ast, $b2.ast); }
    ;

/*block returns [List<Statement> ast = new ArrayList<Statement>()]:
    s1=statement { $ast.add($s1.ast); }
    | '{' (s2=statement { $ast.add($s2.ast); } )+ '}'
    ;*/

block returns [List<Statement> ast = new ArrayList<Statement>()]:
    s1=statement { $s1.ast.stream().forEach(temp -> $ast.add(temp)); }
    | '{' (s2=statement { $s2.ast.stream().forEach(temp -> $ast.add(temp)); } )+ '}'
    ;

expression returns [Expression ast]: //checked by Ortin
            functionInvocation
            { $ast = $functionInvocation.ast; }
            | e1=expression '[' e2=expression ']'
            { $ast = new ArrayAccess($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $e2.ast); }
            | e=expression '.' ID
            { $ast = new FieldAccess($e.ast.getLine(), $e.ast.getColumn(), $e.ast, $ID.text); }
            | '(' t1=builtIn ')' e=expression //cast
            { $ast = new Cast($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, $e.ast); }
            | '-' e1=expression //unary minus
            { $ast = new UnaryMinus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast); }
            | '!' e1=expression //unary not
            { $ast = new UnaryNot($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast); }
            | e1=expression op=('*'|'/'|'%') e2=expression //arithmetic and modulus //HOW TO GET MODULUS
            {
                $ast = LexerHelper.getArithmeticOrModulus($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast);
            }
            | e1=expression op=('+'|'-') e2=expression //arithmetic
            { $ast = new Arithmetic($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast); }
            | e1=expression op=('>' | '>=' | '<' | '<=' | '!=' | '==') e2=expression //comparison
            { $ast = new Relational($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast); }
            | e1=expression op=('&&'|'||') e2=expression // logic
            { $ast = new Logic($e1.ast.getLine(), $e1.ast.getColumn(), $e1.ast, $op.text, $e2.ast); }
            | ID  //Variable
            { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text); }
            | i1=INT_CONSTANT //Int_literal
            { $ast = new IntLiteral($i1.getLine(), $i1.getCharPositionInLine() + 1, LexerHelper.lexemeToInt($i1.text)); }
            | r1=REAL_CONSTANT //Double_literal
            { $ast = new DoubleLiteral($r1.getLine(), $r1.getCharPositionInLine() + 1, LexerHelper.lexemeToReal($r1.text)); }
            | c1=CHAR_CONSTANT //Char_literal
            { $ast = new CharLiteral($c1.getLine(), $c1.getCharPositionInLine() + 1, LexerHelper.lexemeToChar($c1.text)); }
            ;

type returns [Type ast]:
    'struct' '{' r=recordFields '}' //struct
    { $ast = new Struct($r.ast.get(0).getLine(), $r.ast.get(0).getColumn(), $r.ast); }
    | t1=type '[' i=INT_CONSTANT ']' //array type
    { $ast = ArrayType.createArray($t1.ast.getLine(), $t1.ast.getColumn(), $t1.ast, LexerHelper.lexemeToInt($i.text)); }
    | builtIn
    { $ast = $builtIn.ast; }
    ;

returnType returns [Type ast]:
    | s='int'
    { $ast = new Int($s.getLine(), $s.getCharPositionInLine() + 1); }
    | s='double'
    { $ast = new Real($s.getLine(), $s.getCharPositionInLine() + 1); }
    | s='char'
    { $ast = new Char($s.getLine(), $s.getCharPositionInLine() + 1); }
    | s='void'
    { $ast = new VoidType($s.getLine(), $s.getCharPositionInLine() + 1); }
    ;

builtIn returns [Type ast]:
     s='int'
    { $ast = new Int($s.getLine(), $s.getCharPositionInLine() + 1); }
    | s='double'
    { $ast = new Real($s.getLine(), $s.getCharPositionInLine() + 1); }
    | s='char'
    { $ast = new Char($s.getLine(), $s.getCharPositionInLine() + 1); }
    ;

recordFields returns [List<RecordField> ast = new ArrayList<RecordField>()]:
    (t=type ID ';'
    {
        $ast.add(new RecordField($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $ID.text));
    })* //is the syntax "char f, i, g;" accepted in recordfields???
    ;

functionInvocation returns [FunctionInvocation ast] locals [List<Expression> params = new ArrayList<Expression>()]:
                    ID '(' (p=parameters { $params.addAll($p.ast); } )? ')'
                    { $ast = new FunctionInvocation($ID.getLine(), $ID.getCharPositionInLine()+1,
                                                    new Variable($ID.getLine(), $ID.getCharPositionInLine()+1, $ID.text),
                                                    $params);
                    }
                    ;

parameters returns [List<Expression> ast = new ArrayList<Expression>()]:
    e1=expression { $ast.add($e1.ast); }
    (',' e2=expression { $ast.add($e2.ast); })*
    ;

    /* params are arguments and arguments are params
            I decided not to change it because its just naming and I don't want to risk the code */

arguments returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
    (
    (t=builtIn id1=ID { $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $id1.text)); })
    (',' t2=builtIn id2=ID { $ast.add(new VarDefinition($t2.ast.getLine(), $t2.ast.getColumn(), $t2.ast, $id2.text)); })*
    )?
    ;

varDefinition returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]:
    t=type id1=ID { $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $id1.text)); }
    (',' id2=ID { $ast.add(new VarDefinition($t.ast.getLine(), $t.ast.getColumn(), $t.ast, $id2.text)); })*  //the UML is uncompleted (missing relation with variable)
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
