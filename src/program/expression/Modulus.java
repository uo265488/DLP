package program.expression;

import program.AbstractASTNode;

public class Modulus extends AbstractASTNode implements Expression {


    public Expression op1;
    public Expression op2;

    public Modulus(int line, int column, Expression op1, Expression op2) {
        super(line, column);

        this.op1 = op1;
        this.op2 = op2;
    }
}
