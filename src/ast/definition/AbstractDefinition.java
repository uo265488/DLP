package ast.definition;

import ast.AbstractASTNode;
import ast.type.Type;
import semantic.Visitor;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    public String name;
    public int scope = 0;

    public Type type;

    public AbstractDefinition(int line, int column, String name) {
        super(line, column);

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int getScope() {
        return this.scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public Type getType() {
        return this.type;
    }

}
