package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import semantic.Visitor;

public class Print extends AbstractStatementImpl {

    public Expression expression;


    public Print(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Print -> " + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
