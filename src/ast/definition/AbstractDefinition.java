package ast.definition;

import ast.AbstractASTNode;
import ast.type.Type;

public class AbstractDefinition extends AbstractASTNode implements Definition {

    public String name;
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
}
