package ast.type;

import ast.AbstractASTNode;

public class Char extends AbstractASTNode implements Type{
    public Char(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "char";
    }
}
