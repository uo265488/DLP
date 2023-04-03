package semantic;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

import java.lang.reflect.Field;
import java.util.function.Function;

public class TypeCheckingVisitor extends DefaultVisitorImpl<Void, Void> {
    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);
        variable.type = variable.definition.getType();
        return null;
    }

    /**
        P: Indexing: expression1 -> expression2 expression3
        R: expression1.type = expression2.type.squareBrackets(expression3.type)
     */
    @Override
    public Void visit(ArrayAccess arrayAccess, Void param) {
        arrayAccess.setLvalue(true);

        arrayAccess.position.accept(this, null);
        arrayAccess.array.accept(this, null);

        arrayAccess.type = arrayAccess.array.getType().squareBrackets(arrayAccess.position.getType(), arrayAccess);

        return null;
    }

    /**
       P: Assignment: statement -> expression1 expression2
       R: expression2.type.assignTo(expression1.type)
    */
    @Override
    public Void visit(Assignment assignment, Void param) {
        assignment.leftExpression.accept(this, null);
        assignment.rightExpression.accept(this, null);
        //after traversing ¿because it is post order?
        if(!assignment.leftExpression.getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "LValue required in the assignment.");
        assignment.leftExpression.getType().assignTo(assignment.rightExpression.getType(), assignment);
        return null;
    }

    /**
        P: Read/Write: statement -> expression
        R: expression.type.mustBebuiltIn()
     */
    @Override
    public Void visit(Input input, Void param) {
        input.expression.accept(this, null);

        if(!input.expression.getLvalue()) {
            new ErrorType(input.getLine(), input.getColumn(), "LValue required in the input expression.");
        }

        input.expression.getType().mustBeBuiltIn(input);

        return null;
    }
    /**
     P: Read/Write: statement -> expression
     R: expression.type.mustBebuiltIn()
     */
    @Override
    public Void visit(Print print, Void param) {
        print.expression.accept(this, null);

        print.expression.getType().mustBeBuiltIn(print);
        return null;
    }

    /**
        P: Modulus : expression1 -> expression2 expression3
        R: expression1.type = expression2.type.modulus(expression3.type)
    */
    @Override
    public Void visit(Modulus modulus, Void param) {
        modulus.op1.accept(this, null);
        modulus.op2.accept(this, null);

        modulus.type = modulus.op1.getType().modulus(modulus.op2.getType(), modulus);

        return null;
    }
    /**
     P: Arithmetic : expression1 -> expression2 expression3
     R: expression1.type = expression2.type.arithmetic(expression3.type)
     */
    @Override
    public Void visit(Arithmetic arithmetic, Void param) {

        arithmetic.op1.accept(this, null);
        arithmetic.op2.accept(this, null);

        arithmetic.type = arithmetic.op1.getType().arithmetic(arithmetic.op2.getType());

        return null;
    }

    /**
     P: Logic : expression1 -> expression2 expression3
     R: expression1.type = expression2.type.logical(expression3.type)
     */
    @Override
    public Void visit(Logic logic, Void param) {
        logic.op1.accept(this, null);
        logic.op2.accept(this, null);

        logic.type = logic.op1.getType().logical(logic.op2.getType(), logic);

        return null;
    }
    /**
     P: Relational : expression1 -> expression2 expression3
     R: expression1.type = expression2.type.relational(expression3.type)
     */
    @Override
    public Void visit(Relational relational, Void param) {
        relational.op1.accept(this, null);
        relational.op2.accept(this, null);

        relational.type = relational.op1.getType().relational(relational.op2.getType(), relational);
        return null;
    }
    /**
     P: UnaryNot : expression1 -> expression2
     R: expression1.type = expression2.type.logical()
     */
    @Override
    public Void visit(UnaryNot unaryNot, Void param) {
        unaryNot.expression.accept(this, null);
        unaryNot.type = unaryNot.expression.getType().logical(unaryNot);
        return null;
    }
    /**
     P: UnaryMinus : expression1 -> expression2
     R: expression1.type = expression2.type.arithmetic()
     */
    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        unaryMinus.expression.accept(this, null);

        unaryMinus.type = unaryMinus.expression.getType().arithmetic(unaryMinus);

        return null;
    }
    /**
        P: Cast : expression1 -> type expression2
        R: expression1.type = expression2.type.castTo(type)
     */
    @Override
    public Void visit(Cast cast, Void param) {
        cast.castTo.accept(this, null);
        cast.expression.accept(this, null);

        cast.type = cast.expression.getType().castTo(cast.castTo, cast);

        return null;
    }

    /**
        P: While : statement1 -> expression statement2*
        R : expression.type.mustBeBoolean()
     */
    @Override
    public Void visit(While whileStmnt, Void param) {
        whileStmnt.body.stream().forEach(s -> s.accept(this, null));
        whileStmnt.condition.accept(this, null);

        whileStmnt.condition.getType().mustBeBoolean(whileStmnt);

        return null;
    }

    /**
        P: IfElse : statement1 -> expression statement2* (statement3*)?
        R : expression.type.mustBeBoolean()
     */
    @Override
    public Void visit(IfElse ifElse, Void param) {
        ifElse.condition.accept(this, null);
        ifElse.ifBody.stream().forEach(s -> s.accept(this, null));
        ifElse.elseBody.stream().forEach(s -> s.accept(this, null));



        ifElse.condition.getType().mustBeBoolean(ifElse.condition);

        return null;
    }

    /**
        P: FunctionInvocation : expression1 -> expression2 expression3*
        R: expression1.type = expression2.type.parenthesis(
                                expression3*.stream().map(exp -> exp.type).toList();
    */
    public Void visit(FunctionInvocation functionInvocation, Void param) {

        functionInvocation.functionVariable.accept(this, null);
        functionInvocation.arguments.stream().forEach(a -> a.accept(this, null));

        functionInvocation.type = functionInvocation.functionVariable.type.parenthesis(
                functionInvocation.arguments.stream().map(x -> x.getType()).toList(), functionInvocation);

        return null;
    }

    /**
        P: (1) FunctionDefinition : definition -> type varDefinition* statement*
        R: (1) statement*.stream().forEach(statement -> statement.returnType = type.returnType) ???????????????????????????????
     */
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        functionDefinition.body.stream().forEach(s -> s.setReturnType(functionDefinition.type.returnType));

        functionDefinition.type.accept(this, null);
        functionDefinition.body.stream().forEach(s -> s.accept(this, null));

        return null;
    }

    /**
     *  P: (2) Return : statement -> expression
     *  R: (2) expression.type.mustBeSubtype(statement.returnType)
     */
    public Void visit(Return returnSt, Void param) {
        returnSt.expression.accept(this, null);

        returnSt.expression.getType().mustBeBuiltIn(returnSt);
        returnSt.expression.getType().mustBeSubtype(returnSt.getReturnType(), returnSt.expression);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        fieldAccess.lvalue = true; //MEH

        fieldAccess.expression.accept(this, null);

        //Check if it is correct
        fieldAccess.type = fieldAccess.expression.getType().dot(fieldAccess.fieldname, fieldAccess);

        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        charLiteral.type = new Char(charLiteral.getLine(), charLiteral.getColumn());

        return null;
    }
    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        intLiteral.type = new Int(intLiteral.getLine(), intLiteral.getColumn());

        return null;
    }

    @Override
    public Void visit(DoubleLiteral doubleLiteral, Void param) {
        doubleLiteral.type = new Real(doubleLiteral.getLine(), doubleLiteral.getColumn());

        return null;
    }
}
