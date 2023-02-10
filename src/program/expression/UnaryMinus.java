package program.expression;

import program.AbstractASTNode;

public class UnaryMinus extends AbstractASTNode implements Expression {

    public Expression expression;

    public UnaryMinus(int line, int column, Expression operand) {
        super(line, column);

        this.expression = operand;
    }
}
