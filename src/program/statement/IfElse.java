package program.statement;

import program.AbstractASTNode;
import program.expression.Expression;

import javax.swing.plaf.nimbus.State;
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
}
