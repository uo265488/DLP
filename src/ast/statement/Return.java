package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import semantic.Visitor;

public class Return extends AbstractASTNode implements Statement {

    public Expression expression;

    public Return(int line, int column, Expression expression) {
        super(line, column);

        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Return -> " + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
