package program.expression;

import program.AbstractASTNode;
import program.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractASTNode implements Expression, Statement {

    public List<Expression> arguments;
    public Variable functionVariable;

    public FunctionInvocation(int line, int column, Variable functionVariable, List<Expression> arguments) {
        super(line, column);

        this.functionVariable = functionVariable;
        this.arguments = new ArrayList<>(arguments);
    }
}
