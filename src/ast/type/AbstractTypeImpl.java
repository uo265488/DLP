package ast.type;

import ast.ASTNode;
import ast.AbstractASTNode;

import java.util.List;

public abstract class AbstractTypeImpl extends AbstractASTNode implements Type {
    public AbstractTypeImpl(int line, int column) {
        super(line, column);
    }

    @Override
    public char getSuffix() {
        throw new RuntimeException("No suffix available for this Type. ");
    }

    @Override
    public Type arithmetic(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Incompatible types for aritmetic. ");
    }

    @Override
    public int getNumberOfBytes() {
        throw new RuntimeException("It is not possible to getNumberOfBytes of this type. ");
    }

    @Override
    public Type logical(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Incompatible types for logical. ");
    }

    @Override
    public Type relational(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Incompatible types for relational: " + this.getClass().getSimpleName() + " and "
                    +  type.getClass().getSimpleName());
    }

    @Override
    public Type parenthesis(List<Type> types, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Incompatible types for functionInvocation. ");
    }

    @Override
    public Type mustBeBoolean(ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Type must be boolean. ");
    }

    @Override
    public Type logical(ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Not a valid type for logical. ");
    }

    @Override
    public Type arithmetic(ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Not a valid type for arithmetic. ");
    }

    @Override
    public Type castTo(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Cast cannot be performed between this types. ");
    }

    @Override
    public Type assignTo(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Assignment cannot be performed between this types. ");
    }

    @Override
    public Type mustBeSubtype(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Subtyping cannot be performed. ");
    }

    @Override
    public Type modulus(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(),
                "Modulus between this types cannot be performed. ");
    }

    @Override
    public Type squareBrackets(Type type, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "It is not an array. ");
    }

    @Override
    public Type mustBeBuiltIn(ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Type must be built-In");
    }

    @Override
    public Type dot(String fieldName, ASTNode astNode) {
        return new ErrorType(astNode.getLine(), astNode.getColumn(), "Invalid types for fieldAccess. ");
    }
}
