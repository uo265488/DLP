package ast.type;

import ast.AbstractASTNode;
import semantic.Visitor;

public class Int extends AbstractASTNode implements Type {


    public Int(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
