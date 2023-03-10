package ast.expression;

import ast.AbstractASTNode;
import ast.statement.Statement;

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

    @Override
    public String toString() {
        return "FunctionInvocation -> " + functionVariable.toString()
                + " (" + arguments.stream().map(a -> a.toString()).reduce((s, sw) -> s + ", " + sw) + ")";
    }
}
