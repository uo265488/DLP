package program.type;

import program.AbstractASTNode;

public class Integer extends AbstractASTNode implements Type {


    public Integer(int line, int column) {
        super(line, column);
    }
}
