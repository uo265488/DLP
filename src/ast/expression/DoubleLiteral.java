package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class DoubleLiteral extends AbstractExpression{

    public double value;

    public DoubleLiteral(int line, int column, double value) {
        super(line, column);

        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleLiteral -> " + value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
