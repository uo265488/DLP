package program.statement;

import program.AbstractASTNode;
import program.expression.Expression;

public class Input extends AbstractASTNode implements Statement {

    public Expression expression;

    public Input(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }
}
