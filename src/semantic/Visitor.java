package semantic;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public interface Visitor<TP, TR> {
    public TR visit(Program program, TP param);

    public TR visit(Variable variable, TP param);

    public TR visit(Assignment assignment, TP param);

    public TR visit(FunctionDefinition functionDefinition, TP param);

    public TR visit(VarDefinition varDefinition, TP param);

    public TR visit(Arithmetic arithmetic, TP param);

    public TR visit(ArrayAccess arrayAccess, TP param);
    public TR visit(Cast cast, TP param);
    public TR visit(CharLiteral charLiteral, TP param);
    public TR visit(DoubleLiteral doubleLiteral, TP param);
    public TR visit(FieldAccess fieldAccess, TP param);
    public TR visit(FunctionInvocation functionInvocation, TP param);
    public TR visit(IntLiteral intLiteral, TP param);
    public TR visit(Logic logic, TP param);
    public TR visit(Modulus modulus, TP param);
    public TR visit(Relational relational, TP param);
    public TR visit(UnaryMinus unaryMinus, TP param);
    public TR visit(UnaryNot unaryNot, TP param);
    public TR visit(IfElse ifElse, TP param);
    public TR visit(Input input, TP param);
    public TR visit(Print print, TP param);
    public TR visit(Return returnStmnt, TP param);
    public TR visit(While whileStmnt, TP param);
    public TR visit(ArrayType arrayType, TP param);
    public TR visit(Char charType, TP param);
    public TR visit(FunctionType functionType, TP param);
    public TR visit(Int intType, TP param);
    public TR visit(Real real, TP param);
    public TR visit(RecordField recordField, TP param);
    public TR visit(Struct struct, TP param);
    public TR visit(VoidType voidType, TP param);
    public TR visit(ErrorType errorType, TP param);
}
