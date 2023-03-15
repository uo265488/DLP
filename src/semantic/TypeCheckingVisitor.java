package semantic;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VarDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public class TypeCheckingVisitor extends DefaultVisitorImpl<Void, Void> {

    @Override
    public Void visit(Variable variable, Void param) {
        variable.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        assignment.leftExpression.accept(this, null);
        assignment.rightExpression.accept(this, null);
        //after traversing ¿because it is post order?
        if(!assignment.leftExpression.getLvalue())
            new ErrorType(assignment.getLine(), assignment.getColumn(), "LValue required in the assignment.");
        return null;
    }

    @Override
    public Void visit(Input input, Void param) {
        if(!input.expression.getLvalue()) {
            new ErrorType(input.getLine(), input.getColumn(), "LValue required in the input expression.");
        }
        input.expression.accept(this, null);
        return null;
    }

}
