package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class Variable extends AbstractExpression{

    String name;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Variable ->  " + name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
