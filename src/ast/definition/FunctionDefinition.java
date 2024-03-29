package ast.definition;

import ast.statement.Statement;
import ast.type.FunctionType;
import semantic.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    public final FunctionType type;
    public List<Statement> body;


    public FunctionDefinition(int line, int column, FunctionType varType, String name, List<Statement> body) {
        super(line, column, name);
        this.body = body;
        super.type = varType;
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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
