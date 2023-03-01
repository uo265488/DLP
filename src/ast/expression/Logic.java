package ast.expression;

import ast.AbstractASTNode;

public class Logic extends AbstractASTNode implements Expression {


    public Expression op1;
    public Expression op2;
    public String operator;

    public Logic(int line, int column, Expression op1, String operator, Expression op2) {
        super(line, column);

        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
    }
}
