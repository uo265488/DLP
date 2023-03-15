package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class Logic extends AbstractExpression {


    public Expression op1;
    public Expression op2;
    public String operator;

    public Logic(int line, int column, Expression op1, String operator, Expression op2) {
        super(line, column);

        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Logic -> " + op1.toString() + " " + operator + " " + op2.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return null;
    }
}
