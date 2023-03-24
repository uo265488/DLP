package ast.expression;

import ast.AbstractASTNode;
import ast.definition.Definition;
import semantic.Visitor;

public class Variable extends AbstractExpression{

    public String name;
    public Definition definition;

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
