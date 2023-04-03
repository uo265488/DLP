package ast.expression;

import ast.ASTNode;
import ast.type.Type;

public interface Expression extends ASTNode {

    boolean getLvalue();
    void setLvalue(boolean lvalue);

    Type getType();
    void setType(Type type);

}
