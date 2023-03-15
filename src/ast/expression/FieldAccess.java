package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class FieldAccess extends AbstractExpression {

    public String fieldname;
    public Expression expression;

    public FieldAccess(int line, int column, Expression expression, String fieldname) {
        super(line, column);

        this.fieldname = fieldname;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "FieldAccess -> " + expression.toString() + "." + fieldname;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
