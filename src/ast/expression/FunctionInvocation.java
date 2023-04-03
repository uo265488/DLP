package ast.expression;

import ast.AbstractASTNode;
import ast.statement.Statement;
import ast.type.Type;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

    public List<Expression> arguments;
    public Variable functionVariable;
    public Type returnType;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }

    @Override
    public Type getReturnType() {
        return this.returnType;
    }

    @Override
    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }
}
