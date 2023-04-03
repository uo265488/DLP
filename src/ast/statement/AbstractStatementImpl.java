package ast.statement;

import ast.AbstractASTNode;
import ast.type.Type;

public abstract class AbstractStatementImpl extends AbstractASTNode implements Statement {

    private Type returnType;

    public AbstractStatementImpl(int line, int column) {
        super(line, column);
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }
}
