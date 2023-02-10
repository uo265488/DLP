package program.definition;

import program.AbstractASTNode;
import program.statement.Statement;
import program.type.Type;

public class VariableDefinition extends AbstractASTNode implements Definition, Statement {

    public Type type;
    public String name;

    public VariableDefinition(int line, int column, Type varType, String name) {
        super(line, column);

        this.type = varType;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
