package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import semantic.Visitor;

public class Input extends AbstractASTNode implements Statement {

    public Expression expression;

    public Input(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Input -> " + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
