package ast.definition;

import ast.AbstractASTNode;
import ast.type.Type;

public class AbstractDefinition extends AbstractASTNode implements Definition {

    public Type type;
    public String name;
    public AbstractDefinition(int line, int column, Type type, String name) {
        super(line, column);

        this.type = type;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
