package ast.type;

import ast.ASTNode;
import semantic.Visitor;

public class Int extends AbstractTypeImpl {


    public Int(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }

    @Override
    public Type mustBeBoolean(ASTNode astNode) {
        return new Int(astNode.getLine(), astNode.getColumn());
    }

    @Override
    public Type arithmetic(Type type, ASTNode astNode) {
        if(type instanceof Int) {
            return new Int(astNode.getLine(), astNode.getColumn());
        }
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Cannot perform arithmetic operation between Int and " + type.getClass().getName());
    }
    @Override
    public Type modulus(Type type, ASTNode astNode) {
        if(type instanceof Int) {
            return new Int(astNode.getLine(), astNode.getColumn());
        }
        return new ErrorType(type.getLine(), type.getColumn(),
                "Cannot perform arithmetic operation between Int and " + type.getClass().getName());
    }
    @Override
    public Type logical(Type type, ASTNode astNode) {
        if(type instanceof Int) {
            return new Int(astNode.getLine(), astNode.getColumn());
        }
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Cannot perform logical operation between Int and " + type.getClass().getSimpleName());
    }

    @Override
    public Type logical(ASTNode astNode) {
        return new Int(astNode.getLine(), astNode.getColumn());
    }

    @Override
    public Type relational(Type type, ASTNode astNode) {
        if(type instanceof Int) {
            return new Int(astNode.getLine(), astNode.getColumn());
        }
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Cannot perform relational operation between Int and " + type.getClass().getSimpleName());
    }
    @Override
    public Type arithmetic(ASTNode astNode) {
        return new Int(astNode.getLine(),astNode.getColumn());
    }
    @Override
    public Type castTo(Type type, ASTNode astNode) {
        return type;
    }

    @Override
    public Type assignTo(Type type, ASTNode astNode) {

        if(type instanceof Int)
            return type;
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Incompatible types for assignment: "
                        + this.getClass().getSimpleName() + " to " + type.getClass().getSimpleName());
    }

    @Override
    public Type mustBeBuiltIn(ASTNode astNode) {
        return new Int(astNode.getLine(), astNode.getColumn());
    }
    @Override
    public Type mustBeSubtype(Type type, ASTNode astNode) {
        if(type instanceof Int)
            return new Int(astNode.getLine(), astNode.getColumn());

        return new ErrorType(astNode.getLine(),astNode.getColumn(), "The type of the returned expression must be" +
                " the same as the return type declared in the enclosing function");
    }


}
