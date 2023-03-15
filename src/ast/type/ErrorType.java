package ast.type;

import ast.AbstractASTNode;
import errorhandler.ErrorHandler;
import semantic.Visitor;
import utils.ArgumentChecks;

public class ErrorType extends AbstractASTNode implements Type {

    public String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);

        ArgumentChecks.checkString(message);
        this.message = message;

        addError();
    }

    private void addError() {
        ErrorHandler.getInstance().addError(this);
    }


    @Override
    public String toString() {
        return "Error (" + getLine() + ", " + getColumn() + "): " + message;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
