package ast.type;

import ast.AbstractASTNode;
import examples.ast.ASTNode;

public class ArrayType extends AbstractASTNode implements Type {

    private Type type;
    private int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);

        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ArrayType -> " + type.toString() + " [" + size + "]";
    }
}
