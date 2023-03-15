package ast.expression;

import ast.AbstractASTNode;
import ast.type.Type;
import semantic.Visitor;

public class Cast extends AbstractExpression {

    public Type castTo;
    public Expression expression;

    public Cast(int line, int column, Type castTo, Expression expression) {
        super(line, column);

        this.castTo = castTo;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Cast -> (" + castTo.toString() + ") " + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
