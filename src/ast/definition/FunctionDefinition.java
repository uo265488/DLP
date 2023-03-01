package ast.definition;

import ast.AbstractASTNode;
import ast.statement.Statement;
import ast.type.Type;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition implements Definition {
    public List<Statement> body;


    public FunctionDefinition(int line, int column, Type varType, String name, List<Statement> body) {
        super(line, column, varType, name);
        this.body = body;
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
