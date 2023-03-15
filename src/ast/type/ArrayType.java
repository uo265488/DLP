package ast.type;

import ast.AbstractASTNode;
import semantic.Visitor;

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

    public static ArrayType createArray(int line, int col, Type type, int size) {
        if(type instanceof ArrayType) {
            return new ArrayType(line, col, ArrayType.createArray(line, col, ((ArrayType) type).type, size), ((ArrayType)type).size);
        }
        return new ArrayType(line, col, type, size);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
