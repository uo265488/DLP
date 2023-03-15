package ast.definition;

import ast.AbstractASTNode;
import ast.statement.Statement;
import ast.type.Type;
import semantic.Visitor;

public class VarDefinition extends AbstractDefinition implements Statement {

    public Type type;
    public VarDefinition(int line, int column, Type varType, String name) {
        super(line, column,  name);
        this.type = varType;
    }

    @Override
    public String toString() {
        return "VarDefinition -> Type: " + type.toString() + ", Name: " + name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
