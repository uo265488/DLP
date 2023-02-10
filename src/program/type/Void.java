package program.type;

import program.AbstractASTNode;

public class Void extends AbstractASTNode implements Type {
    public Void(int line, int column) {
        super(line, column);
    }
}
