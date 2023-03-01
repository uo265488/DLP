package ast.expression;

import ast.AbstractASTNode;

public class UnaryNot extends AbstractASTNode implements Expression {

    public Expression expression;

    public UnaryNot(int line, int column, Expression operand) {
        super(line, column);

        this.expression = operand;
    }
}