package ast.type;

import ast.AbstractASTNode;
import semantic.Visitor;

public class Real extends AbstractASTNode implements Type {
    public Real(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return null;
    }
}
