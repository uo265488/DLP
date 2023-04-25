package ast.expression;

import ast.AbstractASTNode;
import semantic.Visitor;

public class CharLiteral extends AbstractExpression{

    public char value;

    public CharLiteral(int line, int column, char value) {
        super(line, column);

        this.value = value;
    }
    @Override
    public String toString() {
        return "CharLiteral -> " + value;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP p) {
        return visitor.visit(this, p);
    }
}
