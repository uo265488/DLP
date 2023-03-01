package ast.expression;

import ast.AbstractASTNode;

public class FieldAccess extends AbstractASTNode implements Expression {

    public String fieldname;
    public Expression expression;

    public FieldAccess(int line, int column, Expression expression, String fieldname) {
        super(line, column);

        this.fieldname = fieldname;
        this.expression = expression;
    }
}
