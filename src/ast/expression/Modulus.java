package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class Modulus extends AbstractExpression {


    public Expression op1;
    public Expression op2;

    public Modulus(int line, int column, Expression op1, Expression op2) {
        super(line, column);

        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public String toString() {
        return "Modulus -> " + op1.toString() + " % " + op2.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
