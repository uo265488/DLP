package ast.statement;

import ast.expression.Expression;
import semantic.Visitor;

public class Assignment extends AbstractStatementImpl {

    public Expression leftExpression;
    public Expression rightExpression;

    public Assignment(int line, int column, Expression leftExpression, Expression rightExpression) {
        super(line, column);

        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String toString() {
        return "Assignment -> " + leftExpression.toString() + " = " + rightExpression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
