package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class ArrayAccess extends AbstractExpression {

    public Expression array;
    public Expression position;

    public ArrayAccess(int line, int column, Expression array, Expression position) {
        super(line, column);

        this.array = array;
        this.position = position;
    }

    @Override
    public String toString() {
        return "ArrayAccess -> " + array.toString() + " [" + position + "]";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
