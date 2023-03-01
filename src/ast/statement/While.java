package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractASTNode implements Statement {

    public List<Statement> body;
    public Expression condition;

    public While(int line, int column, Expression condition, List<Statement> body) {
        super(line, column);

        this.body = new ArrayList<>(body);
        this.condition = condition;
    }
}
