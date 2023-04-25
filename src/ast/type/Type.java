package ast.type;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {

    char getSuffix();
    int getNumberOfBytes();
    Type arithmetic(Type type, ASTNode astNode);
    Type logical(Type type, ASTNode astNode);
    Type relational(Type type, ASTNode astNode);
    Type parenthesis(List<Type> types, ASTNode astNode);
    Type mustBeBoolean(ASTNode astNode);
    Type logical(ASTNode astNode);
    Type arithmetic(ASTNode astNode);
    Type castTo(Type type, ASTNode astNode);
    Type mustBeSubtype(Type type, ASTNode astNode);
    Type modulus(Type type, ASTNode astNode);
    Type squareBrackets(Type type, ASTNode astNode);
    Type assignTo(Type type, ASTNode astNode);
    Type mustBeBuiltIn(ASTNode astNode);
    Type dot(String fieldname, ASTNode astNode);
}
