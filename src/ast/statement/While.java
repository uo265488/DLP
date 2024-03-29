package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class While extends AbstractStatementImpl {

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
