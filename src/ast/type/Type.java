package ast.type;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {

    /*
        P: Arithmetic : expression1 -> expression2 expression3
        R: expression1.type = expression2.type.arithmetic(expression3.type)
     */
    Type arithmetic(Type type);

    /*
        P: Logic : expression1 -> expression2 expression3
        R: expression1.type = expression2.type.logical(expression3.type)
    */
    Type logical(Type type);

    /*
        P: Relational : expression1 -> expression2 expression3
        R: expression1.type = expression2.type.relational(expression3.type)
    */
    Type relational(Type type);

    /*
        P: FunctionInvocation : expression1 -> expression2 expression3*
        R: expression1.type = expression2.type.parenthesis(
                                expression3*.stream().map(exp -> exp.type).toList();
    */
    Type parenthesis(List<Type> types);

    /*
        P: While : statement1 -> expression statement2*
        R : expression.type.mustBeBoolean()
     */
    /*
        P: IfElse : statement1 -> expression statement2* (statement3*)?
        R : expression.type.mustBeBoolean()
     */
    Type mustBeBoolean();

    /*
        P: UnaryNot : expression1 -> expression2
        R: expression1.type = expression2.type.logical()
    */
    Type logical();

    /*
        P: UnaryMinus : expression1 -> expression2
        R: expression1.type = expression2.type.arithmetic()
    */
    Type arithmetic();

    /*
        P: Cast : expression1 -> type expression2
        R: expression1.type = expression2.type.castTo(type)
     */
    Type castTo(Type type);

    /*
        P: (1) FunctionDefinition : definition -> type varDefinition* statement*
           (2) Return : statement -> expression

        R: (2) expression.type.mustBeSubtype(statement.returnType)
           (1) statement*.stream().forEach(statement -> statement.returnType = type.returnType) ???????????????????????????????
     */
    Type mustBeSubtype(Type type);














}
