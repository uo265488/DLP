package ast.type;

import ast.AbstractASTNode;

public class RecordField extends AbstractASTNode implements Type{

    public Type type;
    public RecordField(int line, int column, Type type) {
        super(line, column);

        this.type = type;
    }
}
