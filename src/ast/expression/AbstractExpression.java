package ast.expression;

import ast.AbstractASTNode;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    public boolean lvalue = false;

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


}
