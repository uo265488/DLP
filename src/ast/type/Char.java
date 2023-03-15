package ast.type;

import ast.AbstractASTNode;
import semantic.Visitor;

public class Char extends AbstractASTNode implements Type{
    public Char(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
