package program.type;

import program.AbstractASTNode;

public class Double extends AbstractASTNode implements Type {
    public Double(int line, int column) {
        super(line, column);
    }
}
