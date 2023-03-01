package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

public class Input extends AbstractASTNode implements Statement {

    public Expression expression;

    public Input(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }
}
