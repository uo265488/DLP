package program.definition;

import program.AbstractASTNode;
import program.statement.Statement;
import program.type.Type;

import java.util.List;

public class FunctionDefinition extends AbstractASTNode implements Definition {
    public List<Statement> body;
    public Type type;
    public String name;

    public FunctionDefinition(int line, int column, Type varType, String name, List<Statement> body) {
        super(line, column);

        this.type = varType;
        this.name = name;
        this.body = body;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
