package semantic;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public abstract class DefaultVisitorImpl<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Program program, TP param) {
        program.definitionList.stream().forEach(d -> d.accept(this, null));
        return null; //IT SHOULDN'T RETURN NULL
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.leftExpression.accept(this, param);
        return assignment.rightExpression.accept(this, param);
         
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        functionDefinition.body.stream().forEach(s -> s.accept(this, param));
        functionDefinition.type.accept(this, param);
        return null;
    }

    @Override
    public TR visit(VarDefinition varDefinition, TP param) {
        varDefinition.type.accept(this, param);
         return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.op1.accept(this, param);
        return arithmetic.op2.accept(this, param);
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP param) {
        arrayAccess.array.accept(this, param);
        return arrayAccess.position.accept(this, param);
    }

    @Override
    public TR visit(Cast cast, TP param) {

        cast.expression.accept(this, param);
        return cast.castTo.accept(this, param);
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(DoubleLiteral doubleLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        functionInvocation.functionVariable.accept(this, null);
        functionInvocation.arguments.stream().forEach(a -> a.accept(this, null));
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logic logic, TP param) {

        logic.op1.accept(this, null);
        logic.op2.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Modulus modulus, TP param) {
        modulus.op1.accept(this, null);
        modulus.op2.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Relational relational, TP param) {
        relational.op1.accept(this, null);
        relational.op2.accept(this, null);
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(UnaryNot unaryNot, TP param) {
        unaryNot.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        ifElse.condition.accept(this, null);
        ifElse.ifBody.stream().forEach(i -> i.accept(this, null));
        ifElse.elseBody.stream().forEach(i -> i.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Input input, TP param) {
        input.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Print print, TP param) {
        print.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Return returnStmnt, TP param) {
        returnStmnt.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(While whileStmnt, TP param) {
        whileStmnt.condition.accept(this, null);
        whileStmnt.body.stream().forEach(b -> b.accept(this, null));
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {

        return null;
    }

    @Override
    public TR visit(Char charType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        return null;
    }

    @Override
    public TR visit(Int intType, TP param) {
        return null;
    }

    @Override
    public TR visit(Real real, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        return null;
    }

    @Override
    public TR visit(Struct struct, TP param) {
        struct.recordFields.stream().forEach(s -> s.accept(this, null));
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

}
