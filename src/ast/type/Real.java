package ast.type;


import ast.ASTNode;
import semantic.Visitor;

public class Real extends AbstractTypeImpl {
    public Real(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "real";
    }

    @Override
    public int getNumberOfBytes() {
        return 4;
    }

    @Override
    public char getSuffix() {
        return 'f';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return null;
    }

    @Override
    public Type arithmetic(Type type, ASTNode astNode) {
        if(type instanceof Real) {
            return new Real(astNode.getLine(), astNode.getColumn());
        }
        return new ErrorType(type.getLine(), type.getColumn(),
                "Cannot perform arithmetic operation between Real and " + type.getClass().getName());
    }

    @Override
    public Type relational(Type type, ASTNode astNode) {
        if(type instanceof Real) {
            return new Int(astNode.getLine(), astNode.getColumn());
        }
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Cannot perform relational operation between Real and " + type.getClass().getName());
    }
    @Override
    public Type arithmetic(ASTNode astNode) {
        return new Real(astNode.getLine(), astNode.getColumn());
    }

    @Override
    public Type castTo(Type type, ASTNode astNode) {
        return type;
    }
    @Override
    public Type assignTo(Type type, ASTNode astNode) {

        if(type instanceof Real)
            return type;
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Incompatible types for assignment: "
                        + this.getClass().getSimpleName() + " to " + type.getClass().getSimpleName());
    }

    @Override
    public Type mustBeSubtype(Type type, ASTNode astNode) {
        if(type instanceof Real)
            return new Real(astNode.getLine(), astNode.getColumn());

        return new ErrorType(astNode.getLine(),astNode.getColumn(), "The type of the returned expression must be" +
                " the same as the return type declared in the enclosing function");
    }

    @Override
    public Type mustBeBuiltIn(ASTNode astNode) {
        return new Int(astNode.getLine(), astNode.getColumn());
    }


}
