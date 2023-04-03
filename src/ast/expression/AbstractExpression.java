package ast.expression;

import ast.AbstractASTNode;
import ast.type.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    public boolean lvalue = false;
    public Type type;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean getLvalue() {
        return lvalue;
    }

    public void setLvalue(boolean b){
        lvalue = b;
    }

    @Override
    public Type getType() {
        return this.type;
    }
    @Override
    public void setType(Type type) {
        this.type = type;
    }


}
