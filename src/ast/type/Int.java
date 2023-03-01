package ast.type;

import ast.AbstractASTNode;

public class Int extends AbstractASTNode implements Type {


    public Int(int line, int column) {
        super(line, column);
    }
}
