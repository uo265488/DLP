package program.type;

import program.AbstractASTNode;

public class Char extends AbstractASTNode implements Type{
    public Char(int line, int column) {
        super(line, column);
    }
}
