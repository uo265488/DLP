package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractASTNode implements Statement {

    public List<Statement> ifBody;
    public List<Statement> elseBody;
    public Expression condition;


    public IfElse(int line, int column, Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);

        this.ifBody = ifBody;
        this.elseBody = elseBody;
        this.condition = condition;
    }

    public IfElse(int line, int column, Expression condition, List<Statement> ifBody) {
        super(line, column);

        this.ifBody = ifBody;
        this.elseBody = new ArrayList<>();
        this.condition = condition;
    }
}
