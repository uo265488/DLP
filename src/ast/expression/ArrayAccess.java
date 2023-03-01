package ast.expression;

import ast.AbstractASTNode;

public class ArrayAccess extends AbstractASTNode implements Expression {

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
}
