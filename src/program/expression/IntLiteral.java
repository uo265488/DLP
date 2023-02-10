package program.expression;

import program.AbstractASTNode;

public class IntLiteral extends AbstractASTNode implements Expression {

    int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }
}
