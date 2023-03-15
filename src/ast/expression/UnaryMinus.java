package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class UnaryMinus extends AbstractExpression {

    public Expression expression;

    public UnaryMinus(int line, int column, Expression operand) {
        super(line, column);

        this.expression = operand;
    }

    @Override
    public String toString() {
        return "UnaryMinus -> - " + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
