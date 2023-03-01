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

    @Override
    public String toString() {
        return "While ->\n\tCondition:\n" + condition.toString() + "\n\tBody:\n\t" +
                body.stream().map(a -> a.toString()).reduce((s, sw) -> s + "\n\t" + sw) + "\n\t";
    }
}
