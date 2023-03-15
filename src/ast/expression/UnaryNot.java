package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class UnaryNot extends AbstractExpression {

    public Expression expression;

    public UnaryNot(int line, int column, Expression operand) {
        super(line, column);

        this.expression = operand;
    }

    @Override
    public String toString() {
        return "UnaryNot -> ! " + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
