package ast.type;

import ast.ASTNode;
import ast.AbstractASTNode;
import semantic.Visitor;

import java.util.List;

public class ArrayType extends AbstractTypeImpl {

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

    @Override
    public Type squareBrackets(Type type, ASTNode astNode) {
        if(type instanceof Int)
            return this.type;

        return new ErrorType(astNode.getLine(), astNode.getColumn(), "The second operand must be of type Int. ");
    }

    @Override
    public Type assignTo(Type type, ASTNode astNode) {
        if(this.type.getClass().equals(type.getClass()) || type instanceof ArrayType)
            return this;
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Incompatible types for assignment: " + type.getClass().getSimpleName() + " to Array of "
                        + this.type.getClass().getSimpleName());
    }

}
