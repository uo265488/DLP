package ast.definition;

import ast.AbstractASTNode;
import ast.statement.Statement;
import ast.type.Type;

public class VarDefinition extends AbstractDefinition implements Statement {

    public VarDefinition(int line, int column, Type varType, String name) {
        super(line, column, varType, name);
    }
}
