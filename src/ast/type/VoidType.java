package ast.type;

import ast.AbstractASTNode;
import semantic.Visitor;

public class VoidType extends AbstractTypeImpl {
    public VoidType(int line, int column) {
        super(line, column);
    }
    @Override
    public String toString() {
        return "void";
    }

    @Override
    public int getNumberOfBytes() {
        return 0;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
