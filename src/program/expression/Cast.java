package program.expression;

import program.AbstractASTNode;
import program.type.Type;

public class Cast extends AbstractASTNode implements Expression {

    public Type castTo;
    public Expression expression;

    public Cast(int line, int column, Type castTo, Expression expression) {
        super(line, column);

        this.castTo = castTo;
        this.expression = expression;
    }
}
