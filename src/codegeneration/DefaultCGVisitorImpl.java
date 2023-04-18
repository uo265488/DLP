package codegeneration;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;
import semantic.Visitor;

public class DefaultCGVisitorImpl<TP,TR> implements Visitor<TP,TR> {

    @Override
    public TR visit(Program program, TP param) {
        throw new RuntimeException("This node should not be traversed " + program.getClass().getSimpleName() +
                "in line " + program.getLine() + " and column " + program.getColumn() + ". ");
    }

    @Override
    public TR visit(Variable variable, TP param) {
        throw new RuntimeException("This node should not be traversed " + variable.getClass().getSimpleName() +
                "in line " + variable.getLine() + " and column " + variable.getColumn() + ". ");
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        throw new RuntimeException("This node should not be traversed " + assignment.getClass().getSimpleName() +
                "in line " + assignment.getLine() + " and column " + assignment.getColumn() + ". ");
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Cast cast, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Logic logic, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Relational relational, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Input input, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Print print, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Return returnStmnt, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(While whileStmnt, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Char charType, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Int intType, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Real real, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(Struct struct, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        throw new RuntimeException("This node should not be traversed ");
    }
}
