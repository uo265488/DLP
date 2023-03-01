package ast.expression;

import ast.AbstractASTNode;

public class Arithmetic extends AbstractASTNode implements Expression {


    public Expression op1;
    public Expression op2;
    public String operator;

    public Arithmetic(int line, int column, Expression op1, String operator, Expression op2) {
        super(line, column);

        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Arithmetic -> " + op1.toString() + " " + operator + " " + op2.toString();
    }
}
