package ast.type;

import ast.AbstractASTNode;

public class Real extends AbstractASTNode implements Type {
    public Real(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "double";
    }
}
