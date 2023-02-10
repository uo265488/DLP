package program.statement;

import jdk.jshell.ExpressionSnippet;
import program.AbstractASTNode;
import program.expression.Expression;

public class Print extends AbstractASTNode implements Statement {

    public Expression expression;


    public Print(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }
}
