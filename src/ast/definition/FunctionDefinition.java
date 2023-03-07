package ast.definition;

import ast.statement.Statement;
import ast.type.FunctionType;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private final FunctionType type;
    public List<Statement> body;


    public FunctionDefinition(int line, int column, FunctionType varType, String name, List<Statement> body) {
        super(line, column, name);
        this.body = body;
        this.type = varType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "FunctionDefinition:\n\t Type: " + type.toString() + ", Name: " + name + ":\n" +
                "Body {\n" + body.stream().map(def -> def.toString()).reduce((s, d) -> s + "\n" + d) + "\n}";
    }
}
